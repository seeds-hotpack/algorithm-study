import java.io.*;
import java.util.*;

class Main{
    static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] res = new int[2];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        char[][] colors = new char[N][N];
        char[][] colors2 = new char[N][N];
        boolean[][] visited = new boolean[N][N];
        boolean[][] visited2 = new boolean[N][N];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                char c = s.charAt(j);
                colors[i][j] = c;
                colors2[i][j] = (c == 'G') ? 'R' : c;
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]) {
                    bfs(i, j, colors, visited);
                    res[0]++;
                }
                if(!visited2[i][j]) {
                    bfs(i, j, colors2, visited2);
                    res[1]++;
                }
            }
        }
        System.out.println(res[0] + " " + res[1]);
    }
    static void bfs(int i, int j, char[][] colors, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new int[]{i, j});
        while(!q.isEmpty()){
            int[] a = q.poll();
            for(int k=0; k<4; k++){
                int x = a[0] + dr[k];
                int y = a[1] + dc[k];
                if(0 <= x && 0 <= y && x < N && y < N && !visited[x][y] && colors[x][y] == colors[a[0]][a[1]]) {
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
        }
    }
}