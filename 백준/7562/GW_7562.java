import java.util.*;
import java.io.*;

public class Main {

    static int I;
    static int[] start, end;
    static int[][] grid;
    static Queue<int[]> q;

    static int[] dr = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

    public static int bfs() {
        q.offer(start);

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];

            if (r == end[0] && c == end[1]) {
                return grid[r][c];
            }

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isInRange(nr, nc) && grid[nr][nc] == 0) {
                    grid[nr][nc] = grid[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return -1;
    }

    public static boolean isInRange(int r, int c) {
        return (r >= 0 && c >= 0 && r < I && c < I);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            grid = new int[I][I];
            start = new int[2];
            end = new int[2];

            st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            q = new ArrayDeque<>();
            sb.append(bfs()).append("\n");
        }
        System.out.print(sb);
    }
}