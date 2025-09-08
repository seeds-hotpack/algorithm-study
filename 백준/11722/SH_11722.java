import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(A[j]>A[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int result = 0;
        for(int i=0; i<N; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}