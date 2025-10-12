import java.io.*;
import java.util.*;

class Main {
    static int N, M, x, y, K;
    static int[] move;
    static int[] dice = new int[7];
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }

        solve();
        System.out.println(sb);
    }
    static void solve() {
        for(int m : move) {
            int nx = x + dx[m];
            int ny = y + dy[m];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            x = nx; y = ny;

            roll(m);
            if (arr[x][y] == 0) {
                arr[x][y] = dice[2];
            } else {
                dice[2] = arr[x][y];
                arr[x][y] = 0;
            }

            sb.append(dice[1]).append("\n");
        }
    }
    static void roll(int m) {
        int temp;
        switch (m) {
            case 1:
                temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[2];
                dice[2] = dice[6];
                dice[6] = temp;
                break;
            case 2:
                temp = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[2];
                dice[2] = dice[5];
                dice[5] = temp;
                break;
            case 3:
                temp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[2];
                dice[2] = dice[3];
                dice[3] = temp;
                break;
            case 4:
                temp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[2];
                dice[2] = dice[4];
                dice[4] = temp;
                break;
        }
    }
}