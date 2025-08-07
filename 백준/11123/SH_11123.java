import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class SH_11123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            char[][] map = new char[h][w];
            boolean[][] visited = new boolean[h][w];
            int count = 0;
            for(int j = 0; j < h; j++) {
                String line = br.readLine();
                for (int k = 0; k < w; k++) {
                    map[j][k] = line.charAt(k);
                }
            }
            for(int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if(map[j][k] == '#' && !visited[j][k]) {
                        dfs(j, k, map, visited, h, w);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static int[] dj = {-1, 1, 0, 0};
    static int[] dk = {0, 0, -1, 1};

    static void dfs(int j, int k, char[][] map, boolean[][] visited, int h, int w) {
        visited[j][k] = true;
        for (int d = 0; d < 4; d++) {
            int nj = j + dj[d];
            int nk = k + dk[d];
            if (0 <= nj && nj < h && 0 <= nk && nk < w) {
                if (map[nj][nk] == '#' && !visited[nj][nk]) {
                    dfs(nj, nk, map, visited, h, w);
                }
            }
        }
    }
}