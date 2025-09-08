import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N, M;
        int[] coin, dp;
        for(int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            coin = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                coin[j] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());

            dp = new int[M+1];
            dp[0] = 1;

            for(int j=0; j<N; j++) {
                for(int k=coin[j]; k<=M; k++) {
                    dp[k] += dp[k-coin[j]];
                }
            }

            System.out.println(dp[M]);
        }
    }
}