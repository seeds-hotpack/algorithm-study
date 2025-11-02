import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] A;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.add(new int[]{N - 1, 0});
        queue.add(new int[]{N - 1, 1});
        queue.add(new int[]{N - 2, 0});
        queue.add(new int[]{N - 2, 1});

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            solve(d, s);
        }

        int sum = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sum += A[i][j];
            }
        }
        System.out.println(sum);
    }
    static void solve(int d, int s){
        boolean[][] wasCloud = new boolean[N][N];
        List<int[]> movedClouds = new ArrayList<>();

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            int newX = (nowX + dx[d - 1] * s) % N;
            int newY = (nowY + dy[d - 1] * s) % N;
            if(newX < 0) newX += N;
            if(newY < 0) newY += N;

            A[newX][newY]++;
            wasCloud[newX][newY] = true;
            movedClouds.add(new int[]{newX, newY});
        }

        for(int[] cloud : movedClouds) {
            int newX = cloud[0];
            int newY = cloud[1];

            int count = 0;
            for (int i = 1; i < 8; i += 2) {
                int nx = newX + dx[i];
                int ny = newY + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (A[nx][ny] > 0) count++;
            }
            A[newX][newY] += count;
        }

        init(wasCloud);
    }
    static void init(boolean[][] wasCloud){
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!wasCloud[i][j] && A[i][j] >= 2) {
                    A[i][j] -= 2;
                    queue.add(new int[]{i, j});
                }
            }
        }
    }
}