import java.util.*;
import java.io.*;

class Main {
    static int[][] train;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        train = new int[N][20];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = 0;
            if(a <= 2) {
                c = Integer.parseInt(st.nextToken());
            }

            if(a == 1) one(b, c);
            else if(a == 2) two(b, c);
            else if(a == 3) three(b);
            else four(b);
        }

        Set<String> record = new HashSet<>();
        for(int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 20; j++) {
                sb.append(train[i][j]);
            }
            record.add(sb.toString());
        }

        System.out.println(record.size());
    }
    static void one(int b, int c) {
        if(train[b - 1][c - 1] == 0) train[b - 1][c - 1] = 1;
    }
    static void two(int b, int c) {
        if(train[b - 1][c - 1] == 1) train[b - 1][c - 1] = 0;
    }
    static void three(int b) {
        for (int i = 19; i > 0; i--) {
            train[b - 1][i] = train[b - 1][i - 1];
        }
        train[b - 1][0] = 0;
    }
    static void four(int b) {
        for (int i = 0; i < 19; i++) {
            train[b - 1][i] = train[b - 1][i + 1];
        }
        train[b - 1][19] = 0;
    }
}