import java.util.*;
import java.io.*;


public class Main{

    public static void dfs(char[][] grid, boolean[][] visited, int r, int c){
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int next_r = r + dr[i];
            int next_c = c + dc[i];

            if(isInRange(next_r, next_c, grid.length, grid[0].length)){
                if(grid[next_r][next_c] == '#' && !visited[next_r][next_c]){
                    dfs(grid, visited, next_r, next_c);
                }
            }
        }
    }

    public static boolean isInRange(int r, int c, int row_len, int col_len){
        return (r >= 0 && r < row_len) && (c >= 0 && c < col_len);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            char[][] grid = new char[h][w];
            int group = 0;
            boolean[][] visited = new boolean[h][w];

            for (int j = 0; j < h; j++) {
                String line = br.readLine();
                for (int k = 0; k < w; k++) {
                    grid[j][k] = line.charAt(k);
                }
            }

            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if( (grid[j][k] == '#') && !visited[j][k] ){
                        dfs(grid, visited, j, k);
                        group++;
                    }
                }
            }
            sb.append(group).append('\n');
        }
        System.out.print(sb.toString());
    }
}