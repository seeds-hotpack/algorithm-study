import java.util.*;
import java.io.*;

class Main {
    static int N, H, D;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new char[N][N];

        int sx = 0, sy = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }

        System.out.println(bfs(sx, sy));
    }

    static class State {
        int x, y, h, d, step;
        State(int x, int y, int h, int d, int step) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.d = d;
            this.step = step;
        }
    }

    static int bfs(int sx, int sy) {
        Queue<State> q = new LinkedList<>();
        int[][] maxTotal = new int[N][N]; // h + d의 최댓값 저장

        q.add(new State(sx, sy, H, 0, 0));
        maxTotal[sx][sy] = H;

        while (!q.isEmpty()) {
            State now = q.poll();

            if (map[now.x][now.y] == 'E') return now.step;

            if (maxTotal[now.x][now.y] > now.h + now.d) continue;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                int nh = now.h;
                int nd = now.d;

                if (map[nx][ny] == 'U') {
                    nd = D;
                } else {
                    if (nd > 0) nd--;
                    else nh--;
                }

                if (nh <= 0) continue;

                if (maxTotal[nx][ny] < nh + nd) {
                    maxTotal[nx][ny] = nh + nd;
                    q.add(new State(nx, ny, nh, nd, now.step + 1));
                }
            }
        }
        return -1;
    }
}