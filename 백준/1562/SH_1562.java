import java.util.*;
import java.io.*;

class Main {
    static final int MOD = 1000000000;
    static int N;
    static long[][][] dp;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[N+1][10][1024];
        long answer = 0;

        for(int i=0; i<=N; i++) {
            for(int j=0; j<=9; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        for(int i=1; i<=9; i++) {
            int initialMask = (1<<i);
            answer = (answer + solve(1, i, initialMask)) % MOD;
        }
        System.out.println(answer);
    }

    static long solve(int pos, int lastDigit, int usedMask) {
        if(pos == N) {
            if(usedMask == (1 << 10) - 1) {
                return 1;
            } else {
                return 0;
            }
        }

        if(dp[pos][lastDigit][usedMask] != -1) {
            return dp[pos][lastDigit][usedMask];
        }

        long result = 0;

        for(int nextDigit = 0; nextDigit <= 9; nextDigit++) {
            if(Math.abs(lastDigit - nextDigit) == 1) {
                int newMask = usedMask | (1 << nextDigit);
                result = (result + solve(pos + 1, nextDigit, newMask)) % MOD;
            }
        }

        return dp[pos][lastDigit][usedMask] = result;
    }
}