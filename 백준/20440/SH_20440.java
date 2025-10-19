import java.util.*;
import java.io.*;

class Main {
    static List<int[]> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.add(new int[]{start, end});
        }
        solve();
    }
    static void solve() {
        List<int[]> times = new ArrayList<>();

        for (int[] t : arr) {
            times.add(new int[]{t[0], 1});
            times.add(new int[]{t[1], -1});
        }

        times.sort((a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int cnt = 0;
        int max = 0;
        int answerStart = 0;
        int answerEnd = 0;

        for (int i = 0; i < times.size() - 1; i++) {
            cnt += times.get(i)[1];
            int currTime = times.get(i)[0];
            int nextTime = times.get(i + 1)[0];

            if (currTime == nextTime) continue;

            if (cnt > max) {
                max = cnt;
                answerStart = currTime;
                answerEnd = nextTime;
            }else if(cnt == max) {
                if(answerEnd == currTime){
                    answerEnd = nextTime;
                }
            }
        }

        System.out.println(max);
        System.out.println(answerStart + " " + answerEnd);
    }
}