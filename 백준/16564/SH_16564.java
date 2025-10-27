import java.util.*;
import java.io.*;

class Main {
    static int N;
    static long K;
    static int[] xn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        xn = new int[N];

        for(int i=0; i<N; i++) {
            xn[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(xn);

        long result = solve();
        System.out.println(result);
    }
    static long solve() {
        long left = xn[0];
        long right = xn[N - 1] + K;
        long result = left;

        while(left <= right) {
            long mid = (left + right) / 2;

            if(isPossible(mid)) {
                result = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return result;
    }
    static boolean isPossible(long x) {
        long need = 0;

        for(int i=0; i<N; i++) {
            if(xn[i] < x) {
                need += x - xn[i];
                if(need > K) return false;
            }else break;
        }
        return need <= K;
    }
}