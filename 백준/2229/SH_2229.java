import java.util.*;
import java.io.*;

class Main {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] students = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }
        int dp[] = new int[N+1];
        for (int i = 1; i <= N; i++) {
            int max = students[i];
            int min = students[i];
            for (int j = i; j > 0; j--) {
                max = Math.max(max, students[j]);
                min = Math.min(min, students[j]);
                dp[i] = Math.max(dp[i], dp[j-1] + (max - min));
            }
        }
        System.out.println(dp[N]);
    }
}