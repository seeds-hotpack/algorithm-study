import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] count = new int[5];
        int result = 0;

        for(int i=0; i<s.length(); i++) {
            char a = s.charAt(i);
            if(a == 'q') count[0]++;
            else if(a == 'u') {
                if(count[0] == 0) {
                    System.out.println(-1);
                    return;
                }
                count[0]--;
                count[1]++;
            }
            else if(a == 'a') {
                if(count[1] == 0) {
                    System.out.println(-1);
                    return;
                }
                count[1]--;
                count[2]++;
            }
            else if(a == 'c') {
                if(count[2] == 0) {
                    System.out.println(-1);
                    return;
                }
                count[2]--;
                count[3]++;
            }
            else {
                if(count[3] == 0) {
                    System.out.println(-1);
                    return;
                }
                count[3]--;
            }
            result = Math.max(result, count[0] + count[1] + count[2] + count[3]);

        }
        for(int j=0; j<4; j++) {
            if(count[j] != 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(result);
    }
}