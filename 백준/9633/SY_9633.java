import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;
	static int N, cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		dfs(0, 0);
		
		System.out.println(cnt);
	}

	public static void dfs(int depth, int row) {
		if (depth == N) {
			cnt++;
			return;
		}


		for (int p = 0; p < N; p++) {
			int y = row;
			int x = p;

			if (board[y][x] == 0) {
				for (int i = 0; i < N; i++) {
					board[i][x]++;
					board[y][i]++;
				}

				int ny = y;
				int nx = x;
				while(ny >= 0 && nx >= 0) {
					board[ny][nx]++;
					ny--;
					nx--;
				}
				
				ny = y;
				nx = x;
				while(ny < N && nx < N) {
					board[ny][nx]++;
					ny++;
					nx++;
				}
				
				ny = y;
				nx = x;
				while(ny >= 0 && nx < N) {
					board[ny][nx]++;
					ny--;
					nx++;
				}
				
				ny = y;
				nx = x;
				while(ny < N && nx >= 0) {
					board[ny][nx]++;
					ny++;
					nx--;
				}
				
				dfs(depth+1, row + 1);
				
				for (int i = 0; i < N; i++) {
					board[i][x]--;
					board[y][i]--;
				}

				ny = y;
				nx = x;
				while(ny >= 0 && nx >= 0) {
					board[ny][nx]--;
					ny--;
					nx--;
				}
				
				ny = y;
				nx = x;
				while(ny < N && nx < N) {
					board[ny][nx]--;
					ny++;
					nx++;
				}
				
				ny = y;
				nx = x;
				while(ny >= 0 && nx < N) {
					board[ny][nx]--;
					ny--;
					nx++;
				}
				
				ny = y;
				nx = x;
				while(ny < N && nx >= 0) {
					board[ny][nx]--;
					ny++;
					nx--;
				}
			}
		}
	}

}
