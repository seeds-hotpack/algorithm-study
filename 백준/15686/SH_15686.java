import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] city;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j] == 1) houses.add(new int[]{i, j});
                else if(city[i][j] == 2) chickens.add(new int[]{i, j});
            }
        }

        boolean[] selected = new boolean[chickens.size()];
        selectChickens(0, 0, selected);
        System.out.println(min);
    }
    static void selectChickens(int start, int count, boolean[] selected) {
        if(count == M) {
            int d = solve(selected);
            min = Math.min(min, d);
            return;
        }
        for(int i = start; i < chickens.size(); i++) {
            selected[i] = true;
            selectChickens(i+1, count+1, selected);
            selected[i] = false;
        }
    }
    static int solve(boolean[] selected) {
        int result = 0;
        for(int[] house : houses) {
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < chickens.size(); i++) {
                if(selected[i]) {
                    int[] chicken = chickens.get(i);
                    int d = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                    min = Math.min(min, d);
                }
            }
            result += min;
        }
        return result;
    }
}