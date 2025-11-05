import java.util.*;
import java.io.*;

class Main {
    static char left, right;
    static char[][] lKey = {
            {'q', 'w', 'e', 'r', 't'},
            {'a', 's', 'd', 'f', 'g'},
            {'z', 'x', 'c', 'v'}
    };
    static char[][] rKey = {
            {'\0', 'y', 'u', 'i', 'o', 'p'},
            {'\0', 'h', 'j', 'k', 'l'},
            {'b', 'n', 'm'}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        left = st.nextToken().charAt(0);
        right = st.nextToken().charAt(0);

        String s = br.readLine();

        System.out.println(solve(s));
    }
    static int solve(String s) {
        int time = 0;
        for(int i=0; i<s.length(); i++) {
            char k = s.charAt(i);
            if(isLeftKey(k)) {
                int[] now = findPos(left, lKey);
                int[] next = findPos(k, lKey);
                time += Math.abs(now[0] - next[0]) + Math.abs(now[1] - next[1]) + 1;
                left = k;
            }else {
                int[] now = findPos(right, rKey);
                int[] next = findPos(k, rKey);
                time += Math.abs(now[0] - next[0]) + Math.abs(now[1] - next[1]) + 1;
                right = k;
            }
        }
        return time;
    }
    static boolean isLeftKey(char k) {
        for (char[] row : lKey)
            for (char ch : row)
                if (ch == k) return true;
        return false;
    }
    static int[] findPos(char k, char[][] key) {
        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key[i].length; j++) {
                if (key[i][j] == k) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
}