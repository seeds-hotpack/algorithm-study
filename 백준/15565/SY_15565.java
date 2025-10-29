import java.util.*;
import java.io.*;

public class Main {
	static int[][] cogwheels = new int[5][8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		List<Integer> lions = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (st.nextToken().equals("1"))
				lions.add(i);
		}

		if (lions.size() < K) {
			System.out.println(-1);
			return;
		}

		int left = 0, right = K - 1;
		int min = Integer.MAX_VALUE;
		while (right <= lions.size() - 1) {
			int dist = lions.get(right) - lions.get(left) + 1;
			if (min > dist) {
				min = dist;
			}
			left++;
			right++;
		}

		System.out.println(min);

	}

}
