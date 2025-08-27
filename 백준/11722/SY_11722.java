import java.util.*;
import java.io.*;

public class Main {
	static int[] dp;
	static int[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		nums = new int[N];
		dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = 0;
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] < nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}

			len = Math.max(len, dp[i]);

		}

		System.out.println(len);
	}

}
