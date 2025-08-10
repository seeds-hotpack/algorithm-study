import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static char[][] picture;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int normal, daltonism;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		normal = 0;
		daltonism = 0;

		N = Integer.parseInt(br.readLine());

		picture = new char[N][N];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				picture[i][j] = input[j];
			}
		}

		normalBfs();
		daltonismBfs();

		System.out.println(normal + " " + daltonism);
	}

	public static void daltonismBfs() {
		boolean[][] visited = new boolean[N][N];
		Deque<int[]> dq = new ArrayDeque<>();

		char color;
		for (int p = 0; p < N * N; p++) {
			int y = p / N;
			int x = p % N;

			if (visited[y][x])
				continue;

			color = picture[y][x];
			dq.offer(new int[] { y, x });
			visited[y][x] = true;
			daltonism++;
			while (!dq.isEmpty()) {
				int[] yx = dq.poll();
				for (int i = 0; i < 4; i++) {
					int ny = yx[0] + dy[i];
					int nx = yx[1] + dx[i];

					if (isPossableForDaltonism(ny, nx, color) && !visited[ny][nx]) {
						dq.offer(new int[] { ny, nx });
						visited[ny][nx] = true;
					}
				}
			}
		}
	}

	public static void normalBfs() {
		boolean[][] visited = new boolean[N][N];
		Deque<int[]> dq = new ArrayDeque<>();

		char color;
		for (int p = 0; p < N * N; p++) {
			int y = p / N;
			int x = p % N;

			if (visited[y][x])
				continue;

			color = picture[y][x];
			dq.offer(new int[] { y, x });
			visited[y][x] = true;
			normal++;
			while (!dq.isEmpty()) {
				int[] yx = dq.poll();
				for (int i = 0; i < 4; i++) {
					int ny = yx[0] + dy[i];
					int nx = yx[1] + dx[i];

					if (isPossable(ny, nx, color) && !visited[ny][nx]) {
						dq.offer(new int[] { ny, nx });
						visited[ny][nx] = true;
					}
				}
			}
		}
	}

	public static boolean isPossable(int y, int x, char color) {
		return 0 <= x && x < N && 0 <= y && y < N && color == picture[y][x];
	}

	public static boolean isPossableForDaltonism(int y, int x, char color) {
		if (!(0 <= x && x < N && 0 <= y && y < N))
			return false;

		if (color == 'B' && color != picture[y][x])
			return false;

		if (picture[y][x] == 'B' && color != picture[y][x])
			return false;

		return true;
	}

}
