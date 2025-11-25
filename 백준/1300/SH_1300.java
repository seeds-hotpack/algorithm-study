import java.util.*;
import java.io.*;

class Main{
    static int N, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        System.out.println(solve());
    }
    static long solve() {
        long left = 1, right = k;
        long answer = 0;

        while(left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for(int i=1; i<=N; i++) {
                count += Math.min(N, mid / i);
            }

            if (count >= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}