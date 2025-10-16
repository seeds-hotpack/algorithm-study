import java.util.*;
import java.io.*;

public class Main{


    static List<Integer>[] graph;
    static final int INF = Integer.MAX_VALUE;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, INF);

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }

        dij(X);

        boolean flag = true;
        for (int i = 1; i <= N; i++) {
            if(dist[i] == K){
                flag = false;
                System.out.println(i);
            }
        }
        if(flag) System.out.println(-1);
    }

    public static void dij(int X){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(X);
        dist[X] = 0;

        while (!q.isEmpty()){
            int cur = q.poll();

            for(int next: graph[cur]){
                // 아직 방문하지 않았다면
                if (dist[next] == INF) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
}