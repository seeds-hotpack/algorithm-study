import java.util.*;
import java.io.*;

class Main {
    static int[][] position = new int[12][12];
    static boolean[] visited = new boolean[12];
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine());
        for(int i=0; i<C; i++) {
            for(int j=1; j<=11; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=1; k<=11; k++) {
                    position[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            max = 0;
            dfs(1, 0);
            sb.append(max).append("\n");
            Arrays.fill(visited, false);
        }
        System.out.println(sb);
    }
    static void dfs(int pos, int sum) {
        if(pos > 11) {
            max = Math.max(sum, max);
            return;
        }

        for(int i=1; i<=11; i++) {
            if(!visited[i] && position[i][pos] > 0) {
                visited[i] = true;
                dfs(pos+1, sum + position[i][pos]);
                visited[i] = false;
            }
        }
    }
}