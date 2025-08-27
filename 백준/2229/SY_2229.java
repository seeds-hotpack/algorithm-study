import java.util.*;
import java.io.*;

public class Main {
	static int[] dp, std;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		std = new int[N + 1];
		dp = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		int min, max;
		dp[1] = 0;
		for (int i = 1; i <= N; i++) {
			std[i] = Integer.parseInt(st.nextToken());
			min = std[i];
			max = std[i];
			for (int j = i - 1; j > 0; j--) {
				min = Math.min(min, std[j]);
				max = Math.max(max, std[j]);
				dp[i] = Math.max(dp[j - 1] + max - min, dp[i]);
			}
		}

		System.out.println(dp[N]);
	}

}
