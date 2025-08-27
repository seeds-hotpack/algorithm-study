import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] A;
    static int center = 0;
    static int answer = 0;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    static int[][][] spread = {
            {{0,-2,5}, {-1,-1,10}, {1,-1,10}, {-1,0,7}, {1,0,7}, {-2,0,2}, {2,0,2}, {-1,1,1}, {1,1,1}},
            {{2,0,5}, {1,-1,10}, {1,1,10}, {0,-1,7}, {0,1,7}, {0,-2,2}, {0,2,2}, {-1,-1,1}, {-1,1,1}},
            {{0,2,5}, {-1,1,10}, {1,1,10}, {-1,0,7}, {1,0,7}, {-2,0,2}, {2,0,2}, {-1,-1,1}, {1,-1,1}},
            {{-2,0,5}, {-1,-1,10}, {-1,1,10}, {0,-1,7}, {0,1,7}, {0,-2,2}, {0,2,2}, {1,-1,1}, {1,1,1}}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        center = N/2;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve();
    }
    static void solve() {
        int r = center, c = center;
        int len = 1, dir = 0;

        while(true) {
            for(int i=0; i<2; i++) {
                for(int j=0; j<len; j++) {
                    r += dr[dir];
                    c += dc[dir];
                    spreadMethod(r, c, dir);
                    if(r == 0 && c == 0) {
                        System.out.println(answer);
                        return;
                    }
                }
                dir = (dir+1)%4;
            }
            len++;
        }
    }
    static void spreadMethod(int r, int c, int dir) {
        int sand = A[r][c];
        if(sand == 0) return;
        int moved = 0;

        for(int[] s : spread[dir]) {
            int nr = r + s[0];
            int nc = c + s[1];
            int amount = sand * s[2] / 100;
            moved += amount;
            if(nr<0 || nr>=N || nc<0 || nc>=N) answer += amount;
            else A[nr][nc] += amount;
        }

        int ar = r + dr[dir];
        int ac = c + dc[dir];
        int alpha = sand - moved;
        if(ar<0 || ar>=N || ac<0 || ac>=N) answer += alpha;
        else A[ar][ac] += alpha;

        A[r][c] = 0;
    }
}