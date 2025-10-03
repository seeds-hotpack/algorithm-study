import java.util.*;
import java.io.*;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if(N == 1) {
			System.out.println(1);
			return;
		}
		
		dp = new int[N + 1];

		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= N; i++)
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10_007;

		System.out.println(dp[N]);
	}

}
