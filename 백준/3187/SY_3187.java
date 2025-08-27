import java.util.*;
import java.io.*;

public class Main {
	static char[][] board;
	static boolean[][] visited;
	static int C, R;
	static int V, K;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = 0;
		K = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				visited[i][j] = (input[j] == '#');
				board[i][j] = input[j];
			}
		}

		int[] rst = bfs();

		System.out.println(rst[0] + " " + rst[1]);
	}

	// v > k -> die k, v < k -> die v

	public static int[] bfs() {
		Deque<int[]> dq = new ArrayDeque<>();

		int rstV = 0;
		int rstK = 0;
		for (int p = 0; p < R * C; p++) {
			V = 0;
			K = 0;
			int y = p / C;
			int x = p % C;

			if (visited[y][x])
				continue;

			dq.offer(new int[] { y, x });
			visited[y][x] = true;
			countAminal(y, x);

			while (!dq.isEmpty()) {
				int[] xy = dq.poll();

				for (int i = 0; i < 4; i++) {
					int ny = xy[0] + dy[i];
					int nx = xy[1] + dx[i];

					if (isPossable(ny, nx) && !visited[ny][nx]) {
						countAminal(ny, nx);
						dq.offer(new int[] { ny, nx });
						visited[ny][nx] = true;
					}
				}
			}

			if (V >= K)
				rstV += V;
			else
				rstK += K;
		}

		return new int[] { rstK, rstV };
	}

	public static void countAminal(int y, int x) {
		if (board[y][x] == 'v') {
			V++;
		} else if (board[y][x] == 'k') {
			K++;
		}
	}

	public static boolean isPossable(int y, int x) {
		return 0 <= y && y < R && 0 <= x && x < C;
	}

}
