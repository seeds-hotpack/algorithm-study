import java.util.*;
import java.io.*;

class Main {
    static int w, h;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            char[][] arr = new char[h][w];
            Queue<int[]> fire = new LinkedList<>();
            Queue<int[]> person = new LinkedList<>();

            int[][] fireDist = new int[h][w];
            int[][] personDist = new int[h][w];

            for (int j=0; j<h; j++) {
                Arrays.fill(fireDist[j], -1);
                Arrays.fill(personDist[j], -1);
            }

            for(int j=0; j<h; j++) {
                String s = br.readLine();
                for(int k=0; k<w; k++) {
                    arr[j][k] = s.charAt(k);
                    if(arr[j][k] == '*') {
                        fire.add(new int[]{j, k, 0});
                        fireDist[j][k] = 0;
                    }else if(arr[j][k] == '@') {
                        person.add(new int[]{j, k, 0});
                        personDist[j][k] = 0;
                    }
                }
            }
            sb.append(bfs(arr, fire, person, fireDist, personDist)).append('\n');
        }
        System.out.println(sb);
    }
    static String bfs(char[][] arr, Queue<int[]> fire, Queue<int[]> person, int[][] fireDist, int[][] personDist) {
        while(!fire.isEmpty()) {
            int[] now = fire.poll();
            int nowX = now[0];
            int nowY = now[1];
            int time = now[2];

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if(nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) continue;
                if(arr[nextX][nextY] == '#' || arr[nextX][nextY] == '*') continue;
                if(fireDist[nextX][nextY] != -1) continue;
                else {
                    fireDist[nextX][nextY] = time + 1;
                    fire.add(new int[]{nextX, nextY, time + 1});
                }
            }
        }

        while(!person.isEmpty()) {
            int[] now = person.poll();
            int nowX = now[0];
            int nowY = now[1];
            int time = now[2];

            if(nowX == 0 || nowX == h-1 || nowY == 0 || nowY == w-1) {
                return String.valueOf(time + 1);
            }

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if(nextX >= 0 && nextX < h && nextY >= 0 && nextY < w) {
                    if(arr[nextX][nextY] == '#' || personDist[nextX][nextY] != -1) continue;
                    if(fireDist[nextX][nextY] != -1 && fireDist[nextX][nextY] <= time + 1) continue;
                    personDist[nextX][nextY] = time + 1;
                    person.add(new int[]{nextX, nextY, time + 1});
                }
            }
        }

        return "IMPOSSIBLE";
    }
}