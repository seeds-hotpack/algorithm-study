import java.util.*;
import java.io.*;

class Main {
    static int N, result = 0;
    static boolean[] col, diag1, diag2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        col = new boolean[N];
        diag1 = new boolean[2*N-1];
        diag2 = new boolean[2*N-1];

        solve(0);

        System.out.println(result);
    }
    static void solve(int row) {
        if(row == N) {
            result++;
            return;
        }

        for(int j = 0; j < N; j++){
            if(!col[j] && !diag1[row + j] && !diag2[row - j + N - 1]) {
                col[j] = true;
                diag1[row + j] = true;
                diag2[row - j + N - 1] = true;

                solve(row+1);

                col[j] = false;
                diag1[row + j] = false;
                diag2[row - j + N - 1] = false;
            }
        }
    }
}