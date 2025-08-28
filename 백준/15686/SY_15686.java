import java.util.*;
import java.io.*;

public class Main {
	static List<int[]> houses = new ArrayList<>();
	static List<int[]> chickens = new ArrayList<>();
	static int[][] dist;
	static int N, M, ans;
	static int[] chick;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1)
					houses.add(new int[] { i, j });
				else if (num == 2)
					chickens.add(new int[] { i, j });
			}
		}

		dist = new int[houses.size()][chickens.size()];
		chick = new int[M];
		
		int hIdx = 0, cIdx;
		for (int[] house : houses) {
			cIdx = 0;
			for (int[] chicken : chickens) {
				dist[hIdx][cIdx] = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
				cIdx++;
			}
			hIdx++;
		}
		
		dfs(0, 0);
		
		System.out.println(ans);
	}
	

    static void dfs(int depth, int start) {
        if (depth == M) {
            int sum = 0;
            for (int hi = 0; hi < houses.size(); hi++) {
                int best = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    best = Math.min(best, dist[hi][chick[j]]);
                }
                sum += best;
            }
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            chick[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
	

}
