import java.util.*;
import java.io.*;

public class Main {
	static int[] dp, coins;
	static int money;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			coins = new int[N];

			for (int i = 0; i < N; i++)
				coins[i] = Integer.parseInt(st.nextToken());
			money = Integer.parseInt(br.readLine());
			dp = new int[money + 1];
			dp[0] = 1;

			for (int i = 0; i < N; i++) {
				for (int j = coins[i]; j <= money; j++) {
					dp[j] = dp[j] + dp[j - coins[i]];
				}
			}

			sb.append(dp[money]).append("\n");
		}

		System.out.println(sb);

	}

}
