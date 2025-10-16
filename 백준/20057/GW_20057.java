import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] A;
    static int result = 0;

    // 좌, 하, 우, 상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};

    static int[][][] sandRate = {
        { {-1, 1, 1}, {1, 1, 1}, {-2, 0, 2}, {2, 0, 2}, {0, -2, 5}, {-1, 0, 7}, {1, 0, 7}, {-1, -1, 10}, {1, -1, 10} },
        { {-1, -1, 1}, {-1, 1, 1}, {0, -2, 2}, {0, 2, 2}, {2, 0, 5}, {0, -1, 7}, {0, 1, 7}, {1, -1, 10}, {1, 1, 10} },
        { {-1, -1, 1}, {1, -1, 1}, {-2, 0, 2}, {2, 0, 2}, {0, 2, 5}, {-1, 0, 7}, {1, 0, 7}, {-1, 1, 10}, {1, 1, 10} },
        { {1, -1, 1}, {1, 1, 1}, {0, -2, 2}, {0, 2, 2}, {-2, 0, 5}, {0, -1, 7}, {0, 1, 7}, {-1, -1, 10}, {-1, 1, 10} }
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulate();
        System.out.println(result);
    }

    static void simulate() {
        int r = N / 2;
        int c = N / 2;
        int len = 1;
        int dir = 0;

        while (true) {
            for (int t = 0; t < 2; t++) {
                for (int i = 0; i < len; i++) {
                    r += dr[dir];
                    c += dc[dir];
                    spread(r, c, dir);
                    if (r == 0 && c == 0) return;
                }
                dir = (dir + 1) % 4;
            }
            len++;
        }
    }

    static void spread(int r, int c, int dir) {
        int sand = A[r][c];
        if (sand == 0) return;
        A[r][c] = 0;
        int total = 0;

        for (int[] s : sandRate[dir]) {
            int nr = r + s[0];
            int nc = c + s[1];
            int moved = sand * s[2] / 100;
            total += moved;

            if (inRange(nr, nc)) A[nr][nc] += moved;
            else result += moved;
        }

        int remain = sand - total;
        int ar = r + dr[dir];
        int ac = c + dc[dir];
        if (inRange(ar, ac)) A[ar][ac] += remain;
        else result += remain;
    }

    static boolean inRange(int r, int c) {
        return (r >= 0 && r < N && c >= 0 && c < N);
    }
}