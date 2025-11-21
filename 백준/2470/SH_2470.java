import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] res = solve();
        System.out.println(arr[res[0]] + " " + arr[res[1]]);
    }
    static int[] solve() {
        int left = 0;
        int right = N - 1;
        int min = Integer.MAX_VALUE;
        int r1 = arr[left];
        int r2 = arr[right];

        while(left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
                r1 = left;
                r2 = right;
            }

            if(sum > 0) {
                right--;
            }else {
                left++;
            }
        }

        return new int[]{r1, r2};
    }
}