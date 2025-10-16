import java.util.*;
import java.io.*;



public class Main{
    static int N;
    static char[][] grid1, grid2;
    static boolean[][] visited1, visited2;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void bfs(char[][] grid, boolean[][] visited, int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(isInRange(nr, nc)){
                    if(grid[nr][nc] == grid[r][c] && !visited[nr][nc]){
                        q.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }

    public static boolean isInRange(int r, int c){
        return (r>=0 && r<N && c>=0 && c<N);
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        grid1 = new char[N][N];
        grid2 = new char[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                grid1[i][j] = line.charAt(j);
                if(line.charAt(j) == 'G'){
                    grid2[i][j] = 'R';
                } else {
                    grid2[i][j] = line.charAt(j);
                }
            }
        }

        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited1[i][j] == false){
                    bfs(grid1, visited1, i, j);
                    cnt1++;
                }
                if(visited2[i][j] == false){
                    bfs(grid2, visited2, i, j);
                    cnt2++;
                }
            }
        }

        System.out.println(cnt1 + " " + cnt2);
    }
}