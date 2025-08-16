import java.util.*;
import java.io.*;

public class Main {
	static int[] dp;
	static int[] chill;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		dp = new int[N];
		chill = new int[N];
		int lis = 0;
		for (int i = 0; i < N; i++) {
			chill[i] = Integer.parseInt(br.readLine());
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (chill[i] >= chill[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}

			if (dp[i] > lis)
				lis = dp[i];
		}

		System.out.println(N - lis);
	}

}
