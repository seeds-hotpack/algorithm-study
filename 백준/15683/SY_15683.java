import java.util.*;
import java.io.*;

public class Main {
	static int N, M, cnt = Integer.MAX_VALUE;
	static int[][] board;
	static List<int[]> cctvs = new ArrayList<>();
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= board[i][j] && board[i][j] <= 5) {
					cctvs.add(new int[] { i, j });
				}
			}
		}

		if (cctvs.isEmpty()) {
			int empty = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] == 0)
						empty++;
				}
			}

			System.out.println(empty);
			return;
		}

		dfs(0, 0);
		System.out.println(cnt);

	}

	public static void dfs(int depth, int start) {
		if (depth == cctvs.size()) {
			int empty = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] == 0)
						empty++;
				}
			}

			cnt = Math.min(cnt, empty);
			return;
		}

		int[] cctv = cctvs.get(start);

		if (board[cctv[0]][cctv[1]] == 1) {
			for (int i = 0; i < 4; i++) {
				markCCTV(cctv[0], cctv[1], i);
				dfs(depth + 1, start + 1);
				rollbackCCTV(cctv[0], cctv[1], i);
			}
		} else if (board[cctv[0]][cctv[1]] == 2) {
			for (int i = 0; i < 4; i += 2) {
				markCCTV(cctv[0], cctv[1], i);
				markCCTV(cctv[0], cctv[1], i + 1);
				dfs(depth + 1, start + 1);
				rollbackCCTV(cctv[0], cctv[1], i);
				rollbackCCTV(cctv[0], cctv[1], i + 1);
			}
		} else if (board[cctv[0]][cctv[1]] == 3) {
			for (int i = 0; i < 2; i++) {
				for (int j = 2; j < 4; j++) {
					markCCTV(cctv[0], cctv[1], i);
					markCCTV(cctv[0], cctv[1], j);
					dfs(depth + 1, start + 1);
					rollbackCCTV(cctv[0], cctv[1], i);
					rollbackCCTV(cctv[0], cctv[1], j);
				}
			}
		} else if (board[cctv[0]][cctv[1]] == 4) {
			for (int i = 0; i < 4; i++) {
				markCCTV(cctv[0], cctv[1], ((i - 1) % 4 + 4) % 4);
				markCCTV(cctv[0], cctv[1], i);
				markCCTV(cctv[0], cctv[1], (i + 1) % 4);
				dfs(depth + 1, start + 1);
				rollbackCCTV(cctv[0], cctv[1], ((i - 1) % 4 + 4) % 4);
				rollbackCCTV(cctv[0], cctv[1], i);
				rollbackCCTV(cctv[0], cctv[1], (i + 1) % 4);
			}
		} else if (board[cctv[0]][cctv[1]] == 5) {
			markCCTV(cctv[0], cctv[1], 0);
			markCCTV(cctv[0], cctv[1], 1);
			markCCTV(cctv[0], cctv[1], 2);
			markCCTV(cctv[0], cctv[1], 3);
			dfs(depth + 1, start + 1);
			rollbackCCTV(cctv[0], cctv[1], 0);
			rollbackCCTV(cctv[0], cctv[1], 1);
			rollbackCCTV(cctv[0], cctv[1], 2);
			rollbackCCTV(cctv[0], cctv[1], 3);
		}

	}

	public static void markCCTV(int y, int x, int direction) { // 마이너스로 마킹하기, 여기선 실행만
		int ny = y + dy[direction];
		int nx = x + dx[direction];

		while (isPossible(ny, nx)) {
			if (1 <= board[ny][nx] && board[ny][nx] <= 5) {
				ny += dy[direction];
				nx += dx[direction];
				continue;
			}

			board[ny][nx]--;

			ny += dy[direction];
			nx += dx[direction];
		}
	}

	public static void rollbackCCTV(int y, int x, int direction) {
		int ny = y + dy[direction];
		int nx = x + dx[direction];

		while (isPossible(ny, nx)) {
			if (1 <= board[ny][nx] && board[ny][nx] <= 5) {
				ny += dy[direction];
				nx += dx[direction];
				continue;
			}

			board[ny][nx]++;

			ny += dy[direction];
			nx += dx[direction];
		}
	}

	public static boolean isPossible(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < M && board[y][x] != 6;
	}

}
