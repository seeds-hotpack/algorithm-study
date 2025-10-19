import java.util.*;
import java.io.*;

class Main {
    static int N, M, result = 0;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N+1][M+1];

        dfs(1, 1);
        System.out.println(result);
    }
    static void dfs(int x, int y) {
        if(x > N) {
            result++;
            return;
        }
        int nextX = x;
        int nextY = y + 1;
        if(nextY > M) {
            nextX++;
            nextY = 1;
        }

        dfs(nextX, nextY);

        board[x][y] = 1;
        if(isValid(x, y)) dfs(nextX, nextY);
        board[x][y] = 0;
    }
    static boolean isValid(int x, int y) {
        if(x < 2 || y < 2) return true;
        if(board[x-1][y] == 1 && board[x][y-1] == 1 && board[x-1][y-1] == 1) return false;
        return true;
    }
}