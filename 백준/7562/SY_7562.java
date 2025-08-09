import java.util.*;
import java.io.*;

public class Main {
	static int I;
	static boolean[][] board;
	static int[] start = new int[2];
	static int[] end = new int[2];
	static int[][] dyx = { { 2, -1 }, { 2, 1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { -2, -1 }, { -2, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for (int r = 0; r < N; r++) {
			I = Integer.parseInt(br.readLine());

			board = new boolean[I][I];

			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());

			sb.append(bfs()).append("\n");
		}

		System.out.println(sb);
	}

	public static int bfs() {
		Deque<int[]> dq = new ArrayDeque<>();

		if (start[0] == end[0] && start[1] == end[1]) {
			return 0;
		}

		dq.offer(new int[] { start[0], start[1], 0 });
		board[start[0]][start[1]] = true;

		while (!dq.isEmpty()) {
			int[] xy = dq.poll();
			for (int i = 0; i < 8; i++) {
				int ny = xy[0] + dyx[i][0];
				int nx = xy[1] + dyx[i][1];

				if (isPossable(ny, nx) && !board[ny][nx]) {

					if (ny == end[0] && nx == end[1]) {
						return xy[2] + 1;
					}

					dq.offer(new int[] { ny, nx, xy[2] + 1 });
					board[ny][nx] = true;
				}
			}
		}

		return -1;
	}

	public static boolean isPossable(int y, int x) {
		return 0 <= x && x < I && 0 <= y && y < I;
	}

}
