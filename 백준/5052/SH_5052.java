import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] number = new String[n];
            for(int j=0; j<n; j++) {
                number[j] = br.readLine();
            }
            Arrays.sort(number);
            sb.append(solve(n, number)).append("\n");
        }

        System.out.println(sb);
    }
    static String solve(int n, String[] number) {
        for(int i=0; i<n-1; i++) {
            if (number[i+1].startsWith(number[i])) {
                return "NO";
            }
        }
        return "YES";
    }
}