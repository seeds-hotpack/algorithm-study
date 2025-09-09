import java.util.*;
import java.io.*;

class Main {
    static int N, S;
    static int[] row;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        row = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int j=0; j<N; j++) {
            row[j] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (S == 0) count--;
        System.out.println(count);
    }
    static void dfs(int r, int sum) {
        if(r == N) {
            if(sum == S) count++;
            return;
        }
        dfs(r + 1, sum + row[r]);
        dfs(r + 1, sum);
    }
}