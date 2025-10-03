import java.util.*;
import java.io.*;

public class Main {
	static List<List<int[]>> G;
	static int V, E;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		
		G = new ArrayList<>();
		for (int i = 0; i <= V; i++)
			G.add(new ArrayList<>());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			G.get(A).add(new int[] { B, W });
			G.get(B).add(new int[] { A, W });
		}

		System.out.println(prim());

	}

	public static long prim() {
		long ans = 0;
		boolean[] visited = new boolean[V + 1];

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		visited[1] = true;
		for (int[] e : G.get(1)) {
			if (!visited[e[0]])
				pq.offer(e);
		}

		while (!pq.isEmpty()) {
			int[] edge = pq.poll();
			if (visited[edge[0]])
				continue;

			ans += edge[1];
			visited[edge[0]] = true;

			for (int[] e : G.get(edge[0])) {
				if (!visited[e[0]])
					pq.offer(e);
			}
		}

		return ans;
	}

}
