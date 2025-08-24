import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	static int S, N, count = 0;;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);

		if (S == 0)
			count--;

		System.out.println(count);

	}

	public static void dfs(int idx, int sum) {
		if (idx == N) {
			if (sum == S)
				count++;
			return;
		}

		dfs(idx + 1, sum + arr[idx]);

		dfs(idx + 1, sum);
	}

}
