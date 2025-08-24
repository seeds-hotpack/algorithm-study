import java.io.*;
import java.util.*;

class Main{
    static int[][] box;
    static int M, N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                box[i][j] = Integer.parseInt(st2.nextToken());
                if(box[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        int days = bfs(q);
        System.out.println(days);
    }

    static int bfs(Queue<int[]> q){
        int days = 0;
        while(!q.isEmpty()){
            int[] i = q.poll();
            for(int k=0; k<4; k++) {
                int x = i[0] + dr[k];
                int y = i[1] + dc[k];
                if(0 <= x && x < N && 0 <= y && y < M) {
                    if(box[x][y] == 0) {
                        box[x][y] = box[i[0]][i[1]] + 1;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(box[i][j] == 0) return -1;
                days = Math.max(days, box[i][j]);
            }
        }
        return days - 1;
    }
}