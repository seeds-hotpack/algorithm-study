import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] board;
	static int H, W;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			board = new boolean[H][W];

			for (int i = 0; i < H; i++) {
				char[] input = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					if (input[j] == '#')
						board[i][j] = false;
					else
						board[i][j] = true;
				}
			}

			sb.append(bfs()).append("\n");
		}

		System.out.println(sb);
	}

	public static int bfs() {
		int cnt = 0;
		Deque<int[]> dq = new ArrayDeque<>();

		for (int p = 0; p < H * W; p++) {
			int y = p / W;
			int x = p % W;

			if (isVisited(y, x))
				continue;
			

			dq.offer(new int[] { y, x });
			board[y][x] = true;
			cnt++;

			while (!dq.isEmpty()) {
				int[] xy = dq.poll();
				for (int i = 0; i < 4; i++) {
					int ny = xy[0] + dy[i];
					int nx = xy[1] + dx[i];

					if (isPossable(ny, nx) && !isVisited(ny, nx)) {
						dq.offer(new int[] { ny, nx });
						board[ny][nx] = true;
					}
				}
			}
		}

		return cnt;
	}

	public static boolean isVisited(int y, int x) {
		return board[y][x];
	}

	public static boolean isPossable(int y, int x) {
		return 0 <= x && x < W && 0 <= y && y < H;
	}
}
