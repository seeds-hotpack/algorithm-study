import java.util.*;
import java.io.*;

class Main {
    static List<int[]> line = new ArrayList<>();
    static int[] list;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        list = new int[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            line.add(new int[]{a, b});
        }
        Collections.sort(line, (a, b) -> a[0] - b[0]);

        for(int i=0; i<n; i++) {
            list[i] = line.get(i)[1];
        }
        int l = lis();
        System.out.println(list.length - l);
    }
    static int lis() {
        int[] dp = new int[list.length];
        Arrays.fill(dp, 1);
        int result = 1;

        for(int i=1; i<list.length; i++) {
            for(int j=0; j<i; j++) {
                if(list[i] > list[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
}