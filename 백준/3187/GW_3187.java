import java.util.*;
import java.io.*;

public class Main{
    public static final char SHEEP = 'k';
    public static final char WOLF = 'v';
    public static final char FENCE = '#';

    public static int R, C;
    public static int sheep_cnt, wolf_cnt;
    public static char[][] grid;
    public static boolean[][] visited;


    public static void bfs (int r, int c){
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});
        visited[r][c] = true;

        int w = 0;
        int s = 0;

        while (!q.isEmpty()){
            int[] now = q.poll();
            if(grid[now[0]][now[1]] == SHEEP){
                s++;
            } else if(grid[now[0]][now[1]] == WOLF){
                w++;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(isInRange(nr, nc)){
                    if(!visited[nr][nc] && grid[nr][nc] != FENCE){
                        q.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        if( s > w ){
            sheep_cnt += s;
        } else {
            wolf_cnt += w;
        }
    }

    public static boolean isInRange(int r, int c){
        return (r >= 0 && r < R && c >= 0 && c < C);
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        grid = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(!visited[i][j] && grid[i][j] != FENCE){
                    bfs(i, j);
                }
            }
        }

        System.out.print(sheep_cnt + " " + wolf_cnt);
    }
}