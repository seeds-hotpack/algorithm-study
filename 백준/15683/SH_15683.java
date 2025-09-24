import java.util.*;
import java.io.*;

class Main {
    static int N, M, result = Integer.MAX_VALUE;
    static int[][] office;
    static int[][][] cctvDir = {
            {{0}, {1}, {2}, {3}},
            {{0, 1}, {2, 3}},
            {{1, 2}, {1, 3}, {0, 3}, {0, 2}},
            {{0, 1, 2}, {1, 2, 3}, {0, 1, 3}, {0, 2, 3}},
            {{0, 1, 2, 3}}
    };
    static List<int[]> cctvList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if(office[i][j] >= 1 && office[i][j] <= 5){
                    cctvList.add(new int[]{i, j, office[i][j]});
                }
            }
        }

        solve(0);
        System.out.println(result);
    }
    static void solve(int index) {
        if(index == cctvList.size()) {
            int cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(office[i][j] == 0) cnt++;
                }
            }
            result = Math.min(result, cnt);
            return;
        }
        int[] cctv = cctvList.get(index);
        int x = cctv[0];
        int y = cctv[1];
        int type = cctv[2];

        for(int[] dirs : cctvDir[type-1]) {
            int[][] tmp = new int[N][M];
            for(int i=0; i<N; i++) tmp[i] = office[i].clone();

            for(int dir : dirs) {
                watch(tmp, x, y, dir);
            }

            int[][] backup = office;
            office = tmp;
            solve(index + 1);
            office = backup;
        }
    }
    static void watch(int[][] tmp, int x, int y, int dir) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while(nx >= 0 && nx < N && ny >= 0 && ny < M){
            if(tmp[nx][ny] == 6) break;
            if(tmp[nx][ny] == 0) tmp[nx][ny] = -1;
            nx += dx[dir];
            ny += dy[dir];
        }
    }
}