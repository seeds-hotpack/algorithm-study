import java.util.*;
import java.io.*;

public class Main {
	static List<List<int[]>> G = new ArrayList<>();
	static boolean[] visited;
	static PriorityQueue<int[]> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());

		for (int i = 0; i <= V; i++)
			G.add(new ArrayList<>());
		visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			G.get(A).add(new int[] { B, W });
			G.get(B).add(new int[] { A, W });
		}

		System.out.println(prim());

	}

	public static int prim() {
		findAndOfferEdges(1);
		visited[1] = true;
		int ans = 0;
		while (!pq.isEmpty()) {
			int[] edge = pq.poll();
			if (visited[edge[0]])
				continue;
			ans += edge[1];
			findAndOfferEdges(edge[0]);
			visited[edge[0]] = true;
		}

		return ans;
	}

	public static void findAndOfferEdges(int v) {
		for (int[] edge : G.get(v)) {
			if (visited[edge[0]])
				continue;

			pq.offer(edge);
		}
	}

}
