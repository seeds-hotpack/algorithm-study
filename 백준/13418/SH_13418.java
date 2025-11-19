import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] parent;
    static List<int[]> edges = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<M+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a, b, c});
        }

        int a = max();
        int b = min();
        System.out.println(a * a - b * b);
    }
    static int max() {
        List<int[]> sorted = new ArrayList<>(edges);
        sorted.sort((x, y) -> x[2] - y[2]);

        return unionfind(sorted);
    }
    static int min() {
        List<int[]> sorted = new ArrayList<>(edges);
        sorted.sort((x, y) -> y[2] - x[2]);

        return unionfind(sorted);
    }
    static int unionfind(List<int[]> edges) {
        parent = new int[N + 1];
        for(int i = 0; i <= N; i++) parent[i] = i;

        int count = 0;

        for(int[] edge : edges) {
            if(find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                if(edge[2] == 0) count++;
            }
        }

        return count;
    }
    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
}