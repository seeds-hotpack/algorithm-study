import java.util.*;
import java.io.*;

public class Main{
    static int[][] w;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        w = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String temp = br.readLine();
            for (int j = 0; j < temp.length(); j++) {
                w[i][j] = temp.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int wnum = Integer.parseInt(st.nextToken()) - 1;    // index 0부터 시작함
            int dr = Integer.parseInt(st.nextToken());
            turn(wnum, dr);
        }

        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if(w[i][0] == 1){
                cnt += (int)Math.pow(2, i);
            }
        }
        System.out.println(cnt);
    }

    static void turn(int wnum, int dr){
        left(wnum-1, -dr);
        right(wnum+1, -dr);
        rotate(wnum, dr);
    }

    static void left(int wnum, int dr){
        if(wnum < 0) return;
        else if(w[wnum][2] == w[wnum+1][6]) return;
        else {
            left(wnum -1, -dr);
            rotate(wnum, dr);
        }
    }

    static void right(int wnum, int dr){
        if(wnum > 3) return;
        else if(w[wnum][6] == w[wnum-1][2]) return;
        else {
            right(wnum +1, -dr);
            rotate(wnum, dr);
        }
    }

    static void rotate(int wnum, int dr){
        int temp = 0;
        if(dr == 1){
            temp = w[wnum][7];
            for (int i = 7; i > 0; i--) {
                w[wnum][i] = w[wnum][i-1];
            }
            w[wnum][0] = temp;

        } else {
            temp = w[wnum][0];
            for (int i = 0; i < 7; i++) {
                w[wnum][i] = w[wnum][i+1];
            }
            w[wnum][7] = temp;
        }
    }
}