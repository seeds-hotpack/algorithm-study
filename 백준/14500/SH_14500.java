import java.util.*;
import java.io.*;

class Main {
    static int N, M, max = 0;
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, board[i][j], 1);
                visited[i][j] = false;
                checkExtraShape(i, j);
            }
        }

        System.out.println(max);
    }
    static void dfs(int x, int y, int sum, int depth) {
        if(depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
            if(visited[nextX][nextY]) continue;

            visited[nextX][nextY] = true;
            dfs(nextX, nextY, sum + board[nextX][nextY], depth + 1);
            visited[nextX][nextY] = false;
        }
    }
    static void checkExtraShape(int x, int y) {
        // ㅗ
        if (x >= 0 && y + 2 < M && x + 1 < N) {
            int sum = board[x][y] + board[x][y + 1] + board[x][y + 2] + board[x + 1][y + 1];
            max = Math.max(max, sum);
        }
        // ㅜ
        if (x - 1 >= 0 && y + 2 < M) {
            int sum = board[x][y] + board[x][y + 1] + board[x][y + 2] + board[x - 1][y + 1];
            max = Math.max(max, sum);
        }
        // ㅓ
        if (x + 2 < N && y - 1 >= 0) {
            int sum = board[x][y] + board[x + 1][y] + board[x + 2][y] + board[x + 1][y - 1];
            max = Math.max(max, sum);
        }
        // ㅏ
        if (x + 2 < N && y + 1 < M) {
            int sum = board[x][y] + board[x + 1][y] + board[x + 2][y] + board[x + 1][y + 1];
            max = Math.max(max, sum);
        }
    }
}