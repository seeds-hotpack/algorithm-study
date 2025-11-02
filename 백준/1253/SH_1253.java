import java.util.*;
import java.io.*;

class Main {
    static int N;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;
        for(int i=0; i<N; i++) {
            if (isGood(i)) count++;
        }
        System.out.println(count);
    }
    static boolean isGood(int idx) {
        int left = 0;
        int right = N - 1;
        long target = arr[idx];

        while(left < right) {
            if(left == idx) {
                left++;
                continue;
            }
            if (right == idx) {
                right--;
                continue;
            }

            long sum = arr[left] + arr[right];

            if(sum > target) {
                right--;
            }else if(sum < target) {
                left++;
            }else if(target == sum) {
                return true;
            }
        }
        return false;
    }
}