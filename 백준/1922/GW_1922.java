import java.util.*;
import java.io.*;

public class Main{


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N+1];
        int cnt = N;
        int result = 0;
        ArrayList<int[]>[] nodes = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            nodes[A].add(new int[]{B,C});
            nodes[B].add(new int[]{A,C});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.add(new int[]{1, 0});
        while(cnt > 0 && !queue.isEmpty()) {
            int[] now = queue.poll();
            if(visited[now[0]]) continue;
            visited[now[0]] = true;
            cnt--;
            result += now[1];
            for(int[] node : nodes[now[0]]){
                if(!visited[node[0]]) queue.add(node);
            }
        }
        System.out.println(result);
    }
}