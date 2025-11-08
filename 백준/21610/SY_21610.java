import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;
	static boolean[][] cloud;
	static int[] dy = { 0, 0, -1, -1, -1, 0, 1, 1, 1 }; // 2, 4, 6, 8
	static int[] dx = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		cloud = new boolean[N][N];
		initCloud();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			moveCloud(d, s);
			rain();
			startWaterBug();
			createCloud();
		}

		System.out.println(sum());

	}

	public static void initCloud() {
		cloud[N - 1][0] = true;
		cloud[N - 1][1] = true;
		cloud[N - 2][0] = true;
		cloud[N - 2][1] = true;
	}

	public static void moveCloud(int d, int s) {
		boolean[][] c = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloud[i][j]) {
					int y = ((i + dy[d] * s) % N + N) % N;
					int x = ((j + dx[d] * s) % N + N) % N;
					c[y][x] = true;
				}
			}
		}

		cloud = c;
	}

	public static void rain() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloud[i][j]) {
					board[i][j]++;
				}
			}
		}
	}

	public static void startWaterBug() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!cloud[i][j])
					continue;

				for (int p = 2; p <= 8; p += 2) {
					int ny = i + dy[p];
					int nx = j + dx[p];
					if (isPossable(ny, nx) && board[ny][nx] > 0) {
						board[i][j]++;
					}
				}
			}
		}
	}

	public static boolean isPossable(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}

	public static void createCloud() {
		boolean[][] c = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!cloud[i][j] && board[i][j] >= 2) {
					c[i][j] = true;
					board[i][j] -= 2;
				}
			}
		}

		cloud = c;
	}

	public static int sum() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += board[i][j];
			}
		}

		return sum;
	}

}
