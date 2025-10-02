import java.util.*;
import java.io.*;

class Main {
    static String S, P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        P = br.readLine();

        solve();
    }
    static void solve() {
        int count = 0;
        int i = 0;

        while(i < P.length()) {
            int max = 0;
            for(int j=0; j<S.length(); j++) {
                int k = 0;
                while (i + k < P.length() && j + k < S.length() && P.charAt(i + k) == S.charAt(j + k)) {
                    k++;
                }
                max = Math.max(max, k);
            }
            i += max;
            count++;
        }
        System.out.println(count);
    }
}