import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 0) {
                union(b, c);
            }else {
                find(b, c);
            }
        }

        System.out.println(sb);
    }
    static void find(int b, int c) {
        if(findRoot(b) == findRoot(c)) sb.append("YES").append("\n");
        else sb.append("NO").append("\n");
    }
    static void union(int b, int c) {
        int rootB = findRoot(b);
        int rootC = findRoot(c);
        if (rootB != rootC) parent[rootC] = rootB;
    }
    static int findRoot(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = findRoot(parent[x]);
    }
}