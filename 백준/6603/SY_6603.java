import java.util.*;
import java.io.*;

public class Main {
	static int K;
	static int[] nums, result;
	static StringBuilder sb;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());

			if (K == 0)
				break;

			nums = new int[K];
			result = new int[6];
			for (int i = 0; i < K; i++)
				nums[i] = Integer.parseInt(st.nextToken());

			dfs(0, 0);
			sb.append("\n");
		}

		System.out.println(sb);

	}

	public static void dfs(int depth, int idx) {
		if (depth == 6) {
			for (int i = 0; i < 6; i++)
				sb.append(result[i]).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = idx; i <= K - (6 - depth); i++) {
			result[depth] = nums[i];
			dfs(depth + 1, i + 1);
		}
	}

}
