import java.util.*;
import java.io.*;

public class Main{

    static int M, N;
    static int[][] grid;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static Queue<int[]> q = new ArrayDeque<>();


    public static void bfs(){
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(isInRange(nr, nc)){
                    if(grid[nr][nc] == 0){
                        grid[nr][nc] = grid[now[0]][now[1]] + 1;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    public static boolean isInRange(int r, int c){
        return (r>=0 && r<N && c>=0 && c<M);
    }

    public static int countMin(){
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(grid[i][j] == 0){
                    return -1;
                }
                result = Math.max(result, grid[i][j]);
            }
        }
        // 최초 익은 토마토가 1이라 날짜는 -1
        return result -1;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 1){
                    q.offer(new int[]{i, j});
                }
            }
        }

        bfs();
        System.out.print(countMin());
    }
}