import java.util.*;
import java.io.*;

class Main {
    static String s, bomb;
    static int bombLen;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        bomb = br.readLine();
        bombLen = bomb.length();

        solve();

        if(sb.length() == 0) {
            System.out.println("FRULA");
        } else System.out.println(sb);
    }
    static void solve() {
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));

            boolean isBomb = true;
            if (sb.length() >= bombLen) {
                for (int j = 0; j < bombLen; j++) {
                    if (sb.charAt(sb.length() - bombLen + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }
                if (isBomb) {
                    sb.delete(sb.length() - bombLen, sb.length());
                }
            }
        }
    }
}