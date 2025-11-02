import java.util.*;
import java.io.*;

class Main {
    static int N, M, k;
    static int[] friends;
    static List<Integer>[] rel;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        friends = new int[N + 1];
        rel = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) {
            rel[i] = new ArrayList<>();
            friends[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            rel[v].add(w);
            rel[w].add(v);
        }

        solve();
    }
    static void solve() {
        int total = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                total += bfs(i);
            }
        }

        if (total <= k) System.out.println(total);
        else System.out.println("Oh no");
    }
    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        int minCost = friends[start];

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : rel[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    minCost = Math.min(minCost, friends[next]);
                }
            }
        }
        return minCost;
    }
}