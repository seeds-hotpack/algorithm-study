import java.util.*;
import java.io.*;

public class Main {
	static int[] parent, rank;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N+1];
		rank = new int[N+1];
		for(int i = 0; i <= N; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(op == 0) {
				union(a, b);
			} else {
				if(find(a) == find(b)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}
		
		System.out.println(sb);
	}

	public static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}

		return parent[x];
	}

	public static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rank[rootX] > rank[rootY]) {
			parent[rootY] = rootX;
		} else if (rank[rootX] < rank[rootY]) {
			parent[rootX] = rootY;
		} else {
			parent[rootX] = rootY;
			rank[rootY]++;
		}
	}

}
