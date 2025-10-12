import java.util.*;
import java.io.*;

class Main {
    static int N, M, X;
    static List<int[]>[] road, reverse;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        road = new ArrayList[N+1];
        reverse = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            road[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            road[a].add(new int[]{b, c});
            reverse[b].add(new int[]{a, c});
        }

        int[] start = dijkstra(road, X);
        int[] end = dijkstra(reverse, X);

        int max = 0;
        for(int i=1; i<=N; i++) {
            max = Math.max(max, start[i] + end[i]);
        }
        System.out.println(max);
    }
    static int[] dijkstra(List<int[]>[] graph, int start) {
        int[] student = new int[N+1];
        Arrays.fill(student, Integer.MAX_VALUE);
        student[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});

        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowS = now[0];
            int nowT = now[1];

            if (nowT > student[nowS]) continue;

            for(int[] next : graph[nowS]) {
                int nextS = next[0];
                int nextC = next[1];
                if(student[nextS] > student[nowS] + nextC) {
                    student[nextS] = student[nowS] + nextC;
                    pq.offer(new int[]{nextS, student[nextS]});
                }
            }
        }
        return student;
    }
}