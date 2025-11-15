import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static int[] A;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[2 * N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N * 2; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve());
    }
    static int solve() {
        int count = 0;
        while(true) {
            count++;

            rotate();
            moveRobots();

            if (A[0] > 0) {
                robot[0] = true;
                A[0]--;
            }

            if (countZero() >= K) break;
        }
        return count;
    }
    static void rotate() {
        int last = A[2 * N - 1];
        for(int i=2 * N - 1; i>0; i--) {
            A[i] = A[i - 1];
        }
        A[0] = last;

        for(int i=N - 1; i>0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[N - 1] = false;
    }
    static void moveRobots() {
        for(int i = N - 1; i > 0; i--) {
            if(robot[i - 1] && !robot[i] && A[i] > 0) {
                robot[i] = robot[i - 1];
                robot[i - 1] = false;
                A[i]--;
            }
        }
        robot[N - 1] = false;
    }
    static int countZero() {
        int c = 0;
        for(int i=0; i<2 * N; i++) {
            if(A[i] <= 0) c++;
        }
        return c;
    }
}