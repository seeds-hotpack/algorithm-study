import java.util.*;
import java.io.*;

class Main {
    static int[] A, B;
    static int max, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[4];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<4; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        solve(1, A[0]);
        System.out.println(max);
        System.out.println(min);
    }
    static void solve(int idx, int val) {
        if (idx == A.length) {
            max = Math.max(max, val);
            min = Math.min(min, val);
            return;
        }
        for(int i=0; i<4; i++) {
            if(B[i] > 0) {
                B[i]--;
                if(i == 0) solve(idx+1, val+A[idx]);
                else if(i == 1) solve(idx+1, val-A[idx]);
                else if(i == 2) solve(idx+1, val*A[idx]);
                else if (i == 3) solve(idx+1, div(val, A[idx]));
                B[i]++;
            }
        }
    }
    static int div(int a, int b) {
        if (a < 0) return -(-a / b);
        return a / b;
    }
}