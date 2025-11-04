import java.util.*;
import java.io.*;

class Main {
    static int jCash, sCash;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cash = Integer.parseInt(br.readLine());
        jCash = cash;
        sCash = cash;
        arr = new int[14];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<14; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int bResult = BNP();
        int tResult = TIMING();
        if(bResult > tResult) System.out.println("BNP");
        else if(bResult < tResult) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
    static int BNP() {
        int sum = 0;
        for(int i=0; i<14; i++){
            if(jCash >= arr[i]) {
                sum += jCash / arr[i];
                jCash = jCash % arr[i];
            }
        }
        return jCash + sum * arr[13];
    }
    static int TIMING() {
        int sum = 0;
        int up = 0, down = 0;
        for(int i=1; i<14; i++){
            if(arr[i - 1] < arr[i]) {
                up++;
                down = 0;
            }else if(arr[i - 1] > arr[i]){
                down++;
                up = 0;
            }else {
                up = down = 0;
            }

            if(up >= 3) {
                sCash += sum * arr[i];
                sum = 0;
            }else if(down >= 3) {
                sum += sCash / arr[i];
                sCash = sCash % arr[i];
            }
        }
        return sCash + sum * arr[13];
    }
}