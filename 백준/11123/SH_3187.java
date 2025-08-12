import java.io.*;
import java.util.*;

class Main {
    static int[] dj = {-1, 1, 0, 0};
    static int[] dk = {0, 0, -1, 1};
    static int N, M;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        int totalSheep = 0;
        int totalWolf = 0;

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j] && map[i][j] != '#') {
                    int[] result = dfs(i, j);
                    int sheep = result[0];
                    int wolf = result[1];

                    if (sheep > wolf) wolf = 0;
                    else sheep = 0;

                    totalSheep += sheep;
                    totalWolf += wolf;
                }
            }
        }
        System.out.println(totalSheep+" "+totalWolf);
    }

    static int[] dfs(int i, int j) {
        int sheep = 0;
        int wolf = 0;
        if(map[i][j] == 'k') sheep++;
        if(map[i][j] == 'v') wolf++;
        visited[i][j] = true;
        for(int k=0; k<4; k++) {
            int l = i + dj[k];
            int m = j + dk[k];
            if(0 <= l && l < N && 0 <= m && m < M) {
                if(!visited[l][m] && map[i][j] != '#') {
                    int[] result = dfs(l, m);
                    sheep += result[0];
                    wolf += result[1];
                }
            }
        }
        return new int[]{sheep, wolf};
    }
}