import java.util.*;
import java.io.*;

class Main {
    static int[][] board = new int[19][19];
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<19; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<19; i++) {
            for(int j=0; j<19; j++) {
                if(board[i][j] == 0) continue;

                for(int d=0; d<4; d++) {
                    if(check(i, j, d, board[i][j])) {
                        System.out.println(board[i][j]);
                        System.out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }
    static boolean check(int x, int y, int dir, int color) {
        int cnt = 1;
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while(nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && board[nx][ny] == color) {
            cnt++;
            nx += dx[dir];
            ny += dy[dir];
        }

        if(cnt != 5) return false;

        int px = x - dx[dir];
        int py = y - dy[dir];
        if(px >= 0 && px < 19 && py >= 0 && py < 19 && board[px][py] == color) return false;

        return true;
    }
}