import java.util.*;
import java.io.*;

class Main {
    static int N, M, K, X;
    static List<Integer>[] graph;
    static int[] dist;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(dist, -1);

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        q.add(X);
        visited[X] = true;
        dist[X] = 0;

        solve();

        boolean found = false;
        for(int i=1; i<=N; i++) {
            if(dist[i] == K) {
                sb.append(i).append("\n");
                found = true;
            }
        }
        if(!found) System.out.println(-1);
        else System.out.println(sb);
    }
    static void solve() {
        while(!q.isEmpty()) {
            int now = q.poll();

            for(int next : graph[now]) {
                if(!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}