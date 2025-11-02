import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            String s = br.readLine();
            solve(s, sb);
        }

        System.out.println(sb);
    }
    static void solve(String s, StringBuilder sb) {
        int left = 0;
        int right = s.length() - 1;
        int count = 0;

        while(left < right) {
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }else {
                count++;
                if(count > 1) {
                    sb.append(2).append("\n");
                    return;
                }
                if(isPalindrome(s, left + 1, right)) {
                    left++;
                }else if(isPalindrome(s, left, right - 1)) {
                    right--;
                }else {
                    sb.append(2).append("\n");
                    return;
                }
            }
        }
        sb.append(count).append("\n");
    }
    static boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}