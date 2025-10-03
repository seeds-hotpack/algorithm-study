import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static List<int[]>[] graph;
    static boolean[] visited;
    static PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        int result = solve(1);
        System.out.println(result);
    }
    static int solve(int start) {
        queue.add(new int[]{start, 0});

        int count = 0;
        int total = 0;

        while(!queue.isEmpty() && count < N) {
            int now[] = queue.poll();
            int nowA = now[0];
            int nowC = now[1];

            if(visited[nowA]) continue;
            visited[nowA] = true;
            total += nowC;
            count++;

            for(int[] next : graph[nowA]) {
                int nextB = next[0];
                int nextC = next[1];

                if(!visited[nextB]) {
                    queue.add(new int[]{nextB, nextC});
                }
            }
        }
        return total;
    }
}