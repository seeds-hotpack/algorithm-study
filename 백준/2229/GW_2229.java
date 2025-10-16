import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            int max = score[i - 1];
            int min = score[i - 1];
            for (int j = i - 1; j >= 0; j--) {
                max = Math.max(max, score[j]);
                min = Math.min(min, score[j]);
                dp[i] = Math.max(dp[i], dp[j] + (max - min));
            }
        }

        System.out.println(dp[N]);
    }
}