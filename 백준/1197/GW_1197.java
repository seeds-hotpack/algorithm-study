import java.util.*;
import java.io.*;


public class Main{
    static int V, E;
    static List<int[]>[] graph;
    static boolean visited[];

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        visited = new boolean[V+1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }
        System.out.println(prim(1));
    }

    static long prim(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{start, 0});

        long total = 0;
        int count = 0;

        while(!pq.isEmpty() && count < V){
            int[] cur = pq.poll();
            int v = cur[0], w = cur[1];
            if(visited[v]) continue;
            visited[v] = true;

            total += w;
            count++;

            for(int[] next : graph[v]){
                if(!visited[next[0]]) pq.offer(next);
            }
        }
        return total;
    }
}