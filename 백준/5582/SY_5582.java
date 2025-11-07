import java.util.*;
import java.io.*;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] S = br.readLine().toCharArray();
		char[] T = br.readLine().toCharArray();

		dp = new int[S.length + 1][T.length + 1];

		int max = 0;
		for (int i = 1; i <= S.length; i++) {
			for (int j = 1; j <= T.length; j++) {
				if (S[i - 1] == T[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		System.out.println(max);

	}

}
