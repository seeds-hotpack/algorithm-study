import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static long result = 0L;
    static int[] A;
    static long[] sum;
    static Map<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N+1];
        sum = new long[N+1];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + A[i];
        }
        solve();
        System.out.println(result);
    }
    static void solve() {
        for(int i=1; i<=N; i++) {
            if(sum[i] == K) result++;
            result += map.getOrDefault(sum[i] - K, 0L);
            map.put(sum[i], map.getOrDefault(sum[i], 0L) + 1);
        }
    }
}