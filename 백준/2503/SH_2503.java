import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=9; i++) {
            for(int j=1; j<=9; j++) {
                for(int k=1; k<=9; k++) {
                    if (i != j && j != k && i != k) {
                        list.add(i * 100 + j * 10 + k);
                    }
                }
            }
        }

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            List<Integer> next = new ArrayList<>();
            for(int candidate : list) {
                if(check(candidate, num, strike, ball)) {
                    next.add(candidate);
                }
            }
            list = next;
        }
        System.out.println(list.size());
    }
    static boolean check(int candidate, String num, int strike, int ball) {
        int s = 0;
        int b = 0;

        int c1 = candidate/100;
        int c2 = candidate/10%10;
        int c3 = candidate%10;

        int n1 = num.charAt(0) - '0';
        int n2 = num.charAt(1) - '0';
        int n3 = num.charAt(2) - '0';

        if (c1 == n1) s++;
        if (c2 == n2) s++;
        if (c3 == n3) s++;

        if (c1 == n2 || c1 == n3) b++;
        if (c2 == n1 || c2 == n3) b++;
        if (c3 == n1 || c3 == n2) b++;

        return s == strike && b == ball;
    }
}