import java.util.*;
import java.io.*;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;

		st = new StringTokenizer(br.readLine());
		int[] A = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			union(v, w);
		}

		Map<Integer, Integer> roots = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			int root = find(i);
			if (!roots.containsKey(root)) {
				roots.put(root, A[i]);
			} else if (roots.containsKey(root) && roots.get(root) > A[i])
				roots.replace(root, A[i]);
		}

		int total = 0;
		for (int i = 1; i <= N; i++) {
			int root = find(i);
			if (root == 0)
				continue;

			total += roots.get(root);
			if (K < total) {
				System.out.println("Oh no");
				return;
			}

			union(0, root);
		}

		System.out.println(total);

	}

	public static void union(int x, int y) {
		int rootY = find(y);
		int rootX = find(x);

		if (rootY != rootX) {
			parent[rootY] = rootX;
		}
	}

	public static int find(int x) {
		if (x != parent[x])
			parent[x] = find(parent[x]);
		return parent[x];
	}

}
