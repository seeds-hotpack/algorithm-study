import java.util.*;
import java.io.*;

public class Main {
	static int[][] cogwheels = new int[5][8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i < 5; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++)
				cogwheels[i][j] = Integer.parseInt(Character.toString(input[j]));
		}

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cIdx = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			bfs(cIdx, direction);
		}

		System.out.println(calculateTotalScore());
	}

	public static void bfs(int start, int dir) {
		boolean[] visited = new boolean[5];
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { start, dir });
		visited[start] = true;

		while (!dq.isEmpty()) {
			int[] now = dq.poll();

			for (int i = -1; i <= 1; i++) {
				int nn = now[0] + i;
				if (isPossable(nn) && !visited[nn] && isRotationRequired(now[0], nn)) {
					dq.offer(new int[] { nn, now[1] * -1 });
					visited[nn] = true;
				}
			}

			rotate(now[0], now[1]);
		}
	}

	public static boolean isPossable(int n) {
		return 1 <= n && n < 5;
	}

	public static void rotate(int cIdx, int direction) {
		if (direction == 1) {
			int tmp = cogwheels[cIdx][7];
			for (int i = 6; i >= 0; i--)
				cogwheels[cIdx][i + 1] = cogwheels[cIdx][i];
			cogwheels[cIdx][0] = tmp;
		} else {
			int tmp = cogwheels[cIdx][0];
			for (int i = 1; i < 8; i++)
				cogwheels[cIdx][i - 1] = cogwheels[cIdx][i];
			cogwheels[cIdx][7] = tmp;
		}
	}

	public static boolean isRotationRequired(int cIdx1, int cIdx2) {
		if (cIdx1 < cIdx2)
			return cogwheels[cIdx1][2] != cogwheels[cIdx2][6];
		return cogwheels[cIdx1][6] != cogwheels[cIdx2][2];
	}

	public static int calculateTotalScore() {
		int total = 0;

		int num = 1;
		for (int i = 1; i < 5; i++) {
			total += num * cogwheels[i][0];
			num *= 2;
		}

		return total;
	}

}
