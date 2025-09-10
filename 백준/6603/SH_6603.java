import java.util.*;
import java.io.*;

class Main {
    static int[] S;
    static int[] lotto = new int[6];
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            S = new int[k];
            for(int i=0; i<k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            System.out.println();
        }
    }
    static void dfs(int idx, int cnt) {
        if(cnt == 6) {
            for(int i=0; i<6; i++) {
                System.out.print(lotto[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=idx; i<k; i++) {
            lotto[cnt] = S[i];
            dfs(i+1, cnt+1);
        }
    }
}