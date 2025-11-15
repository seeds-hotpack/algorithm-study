import java.util.*;
import java.io.*;

class Main {
    static int[][] dp;
    static String s1;
    static String s2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        s1 = br.readLine();
        s2 = br.readLine();

        int n = s1.length();
        int m = s2.length();
        dp = new int[n + 1][m + 1];

        lcs();

        int i = n, j = m;
        while(i > 0 && j > 0) {
            if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if(dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println(sb.reverse().toString());
    }
    static void lcs() {
        for(int i=1; i<=s1.length(); i++) {
            for(int j=1; j<=s2.length(); j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
    }
}