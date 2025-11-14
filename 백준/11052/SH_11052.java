import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] P, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        P = new int[N + 1];
        dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        solve();
        System.out.println(dp[N]);
    }
    static void solve() {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + P[j]);
            }
        }
    }
}