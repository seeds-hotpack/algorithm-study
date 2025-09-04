import java.util.*;
import java.io.*;

class Main {
    static int[] row;
    static int N;
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        row = new int[N];
        for(int i=0; i<N; i++){
            row[i] = Integer.parseInt(br.readLine());
        }
        int ans = lis();
        int result = N - ans;
        System.out.println(result);
    }
    static int lis() {
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int max = 1;

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++) {
                if(row[j] < row[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}