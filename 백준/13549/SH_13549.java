import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int[] dist;
    static Deque<Integer> deque = new ArrayDeque<>();
    static final int MAX = 200000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[200001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;

        deque.add(N);
        bfs();
        System.out.println(dist[K]);
    }
    static void bfs() {
        while(!deque.isEmpty()) {
            int now = deque.poll();

            if(now == K) break;

            if(2*now <= MAX && dist[2*now] > dist[now]) {
                dist[2*now] = dist[now];
                deque.addFirst(2*now);
            }
            if(1+now <= MAX && dist[1+now] > dist[now]+1) {
                dist[1+now] = dist[now]+1;
                deque.add(1+now);
            }
            if(now-1 >= 0 && dist[now-1] > dist[now]+1) {
                dist[now-1] = dist[now]+1;
                deque.add(now-1);
            }
        }
    }
}