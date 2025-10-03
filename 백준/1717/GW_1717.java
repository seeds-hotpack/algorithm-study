import java.util.*;
import java.io.*;

public class Main{

    static int[] parent;
    static int[] rank;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        rank = new int[n+1];
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[3];
            for (int j = 0; j < 3; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            if(temp[0] == 0){
                union(temp[1], temp[2]);
            } else if(temp[0] == 1){
                if( find(temp[1]) == find(temp[2])){
                    sb.append("yes\n");
                }else{
                    sb.append("no\n");
                }
            }
        }

        System.out.print(sb);
    }

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return;

        if (rank[rootA] > rank[rootB]){
            parent[rootB] = rootA;
        } else if (rank[rootA] < rank[rootB]){
            parent[rootA] = rootB;
        } else{
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }

    static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

}