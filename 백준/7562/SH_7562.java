import java.io.*;
import java.util.*;

class Main{
    static int I;
    static boolean[][] visited;
    static int[] result;
    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st, st2;

        int testcases = Integer.parseInt(br.readLine());
        result = new int[testcases];
        for(int j=0; j<testcases; j++){
            I = Integer.parseInt(br.readLine());
            visited = new boolean[I][I];
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            st2 = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(st2.nextToken());
            int d = Integer.parseInt(st2.nextToken());

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{a, b, 0});
            result[j] = bfs(q, c, d);
        }
        for(int j=0; j<testcases; j++){
            System.out.println(result[j]);
        }
    }
    static int bfs(Queue<int[]> q, int c, int d) {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]][cur[1]] = true;
            if(cur[0] == c && cur[1] == d) return cur[2];
            for(int k=0; k<8; k++) {
                int x = cur[0] + dr[k];
                int y = cur[1] + dc[k];
                if(x == c && y == d) return cur[2] + 1;
                if(0 <= x && 0 <= y && x < I && y < I && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new int[]{x, y, cur[2] + 1});
                }
            }
        }
        return -1;
    }
}