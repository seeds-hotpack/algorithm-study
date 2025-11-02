import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve());
    }
    static int solve() {
        int left = 0, right = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        while(true) {
            if(count >= K) {
                minLen = Math.min(minLen, right - left);
                if(arr[left] == 1) count--;
                left++;
            }else if(right == N) {
                break;
            }else {
                if (arr[right] == 1) count++;
                right++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }
}