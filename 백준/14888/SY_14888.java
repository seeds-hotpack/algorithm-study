import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int[] arr, operator;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		operator = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			operator[i] = Integer.parseInt(st.nextToken());

		dfs(1, arr[0]);

		System.out.println(max + "\n" + min);
	}

	public static void dfs(int idx, int result) {
		if (idx == N) {
			min = Math.min(min, result);
			max = Math.max(max, result);
		}

		for (int i = 0; i < 4; i++) {
			if (i == 0 && operator[i] > 0) {
				operator[i]--;
				dfs(idx + 1, result + arr[idx]);
				operator[i]++;
			}

			if (i == 1 && operator[i] > 0) {
				operator[i]--;
				dfs(idx + 1, result - arr[idx]);
				operator[i]++;
			}

			if (i == 2 && operator[i] > 0) {
				operator[i]--;
				dfs(idx + 1, result * arr[idx]);
				operator[i]++;
			}

			if (i == 3 && operator[i] > 0) {
				operator[i]--;
				dfs(idx + 1, result / arr[idx]);
				operator[i]++;
			}
		}
	}

}
