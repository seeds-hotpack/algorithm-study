import java.util.*;
import java.io.*;


public class Main{

    static String S, P;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        P = br.readLine();

        int cnt = 0;
        int now = 0;

        while(now < P.length()){
            int max = 0;
            for (int i = 1; now + i <= P.length(); i++) {
                String s = P.substring(now, now + i);
                if(S.contains(s)){
                    max = i;
                } else {
                    break;
                }
            }

            now += max;
            cnt++;
        }

        System.out.println(cnt);
    }
}