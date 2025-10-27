import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            solve(W, K);
        }
    }

    static void solve(String w, int k) {
        int min = Integer.MAX_VALUE;
        int max = -1;

        List<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < 26; i++) pos[i] = new ArrayList<>();
        for (int i = 0; i < w.length(); i++) {
            pos[w.charAt(i) - 'a'].add(i);
        }

        for(int i = 0; i < 26; i++) {
            List<Integer> list = pos[i];
            if(list.size() < k) continue;

            for (int j = 0; j <= list.size() - k; j++) {
                int len = list.get(j + k - 1) - list.get(j) + 1;
                max = Math.max(max, len);
                min = Math.min(min, len);
            }
        }

        if (max == -1) System.out.println(-1);
        else System.out.println(min + " " + max);
    }
}