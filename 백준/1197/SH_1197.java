import java.util.*;
import java.io.*;

class Main {
    static int V, E;
    static List<int[]>[] graph;
    static boolean[] visited;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        visited = new boolean[V+1];
        for(int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new int[]{B, C});
            graph[B].add(new int[]{A, C});
        }

        prim(1);
    }
    static void prim(int start) {
        long result = 0;
        int count = 0;

        visited[start] = true;
        for(int[] g : graph[start]) {
            pq.offer(new int[]{g[1], g[0]});
        }

        while(!pq.isEmpty() && count < V-1) {
            int[] now = pq.poll();
            int node = now[1];
            int weight = now[0];

            if(!visited[node]) {
                visited[node] = true;
                result += weight;
                count++;

                for(int[] g: graph[node]) {
                    if(!visited[g[0]]) {
                        pq.offer(new int[]{g[1], g[0]});
                    }
                }
            }
        }
        System.out.println(result);
    }
}