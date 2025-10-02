import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] S = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();

		int cnt = 0;
		for (int i = 0; i < P.length;) {
			cnt++;
			int max = 1;
			for (int j = 0; j < S.length; j++) {
				int len = 0;
				for (int k = j; k < S.length; k++) {
					if (P[i + len] == S[k]) {
						len++;
						if (i + len >= P.length)
							break;
					} else
						break;
				}
				if (max < len)
					max = len;
			}

			i += max;
		}

		System.out.println(cnt);
	}

}
