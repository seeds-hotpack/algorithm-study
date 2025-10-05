import java.util.*;
import java.io.*;

class Main {
    static List<Integer>[] wheel = new ArrayList[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<4; i++) {
            wheel[i] = new ArrayList<>();
            String s = br.readLine();
            for(int j=0; j<8; j++) {
                int k = s.charAt(j) - '0';
                wheel[i].add(k);
            }
        }

        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int wheelNum = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            solve(wheelNum, dir);
        }

        int sum = 0;
        for(int i=0; i<4; i++) {
            if(wheel[i].get(0) == 0) {
                continue;
            } else if (i == 0) {
                sum += 1;
            } else if (i == 1) {
                sum += 2;
            } else if (i == 2) {
                sum += 4;
            } else if (i == 3) {
                sum += 8;
            }
        }
        System.out.println(sum);
    }
    static void solve(int wheelNum, int dir) {
        wheelNum--;

        int[] dirs = new int[4];
        dirs[wheelNum] = dir;

        for(int i=wheelNum; i>0; i--) {
            if (wheel[i].get(6) != wheel[i - 1].get(2)) {
                dirs[i - 1] = -dirs[i];
            } else break;
        }

        for(int i=wheelNum; i<3; i++) {
            if(wheel[i].get(2) != wheel[i + 1].get(6)) {
                dirs[i + 1] = -dirs[i];
            } else break;
        }

        for(int i=0; i<4; i++) {
            if(dirs[i] != 0) {
                rotate(wheel[i], dirs[i]);
            }
        }
    }
    static void rotate(List<Integer> w, int dir) {
        if(dir == 1) {
            int last = w.remove(7);
            w.add(0, last);
        } else {
            int first = w.remove(0);
            w.add(first);
        }
    }
}