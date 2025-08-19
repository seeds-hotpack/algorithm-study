import java.util.*;
import java.io.*;

public class Main {
	static int[][] dp;
	static char[] s1, s2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		s1 = br.readLine().toCharArray();
		s2 = br.readLine().toCharArray();

		dp = new int[s1.length + 1][s2.length + 1];

		for (int i = 1; i <= s1.length; i++) {
			for (int j = 1; j <= s2.length; j++) {
				if (s1[i - 1] == s2[j - 1])
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}

		System.out.println(dp[s1.length][s2.length]);

	}

}
