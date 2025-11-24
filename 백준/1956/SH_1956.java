import java.util.*;
import java.io.*;

class Main {
    static int V, E;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dp = new int[V][V];

        for(int i=0; i<V; i++) {
            for(int j=0; j<V; j++) {
                if(i != j) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            dp[a][b] = Math.min(dp[a][b], c);
        }

        solve();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) continue;
                if (dp[i][j] == Integer.MAX_VALUE) continue;
                if (dp[j][i] == Integer.MAX_VALUE) continue;

                min = Math.min(min, dp[i][j] + dp[j][i]);
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
    static void solve() {
        for(int k=0; k<V; k++) {
            for(int i=0; i<V; i++) {
                if (dp[i][k] == Integer.MAX_VALUE) continue;
                for(int j=0; j<V; j++) {
                    if (dp[k][j] == Integer.MAX_VALUE) continue;

                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
    }
}