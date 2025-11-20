import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] A;
    static int[][] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        B = new int[N][M];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                A[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                B[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(solve());
    }
    static int solve() {
        int count = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(A[i][j] != B[i][j] && i + 2 < N && j + 2 < M) {
                    reverse(i, j);
                    count++;
                }else if(A[i][j] != B[i][j]) {
                    return -1;
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(A[i][j] != B[i][j]) {
                    return -1;
                }
            }
        }

        return count;
    }
    static void reverse(int i, int j) {
        for(int k=i; k<i+3; k++) {
            for(int l=j; l<j+3; l++) {
                if(A[k][l] == 0) {
                    A[k][l] = 1;
                }else {
                    A[k][l] = 0;
                }
            }
        }
    }
}