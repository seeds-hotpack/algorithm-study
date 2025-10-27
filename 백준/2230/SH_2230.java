import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);

        System.out.println(solve());
    }
    static int solve() {
        int left = 0, right = 0, dif = Integer.MAX_VALUE;

        while(left < N && right < N) {
            int diff = A[right] - A[left];

            if(diff < M) {
                right++;
            }else {
                dif = Math.min(dif, diff);
                left++;
            }
        }
        return dif;
    }
}