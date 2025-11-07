import java.util.*;
import java.io.*;

public class Main {
	static char[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			input = br.readLine().toCharArray();
			int l = 0, r = input.length - 1;

			sb.append(isPalindrome(l, r, false)).append("\n");
		}

		System.out.println(sb);
	}

	public static int isPalindrome(int left, int right, boolean delete) {

		int leftRst = 0;
		int rightRst = 0;

		while (left < right) {
			if (input[left] == input[right]) {
				left++;
				right--;
			} else {
				if (!delete) {
					leftRst = isPalindrome(left + 1, right, true);
					rightRst = isPalindrome(left, right - 1, true);
					break;
				} else
					return 2;

			}
		}

		if (left < right) {
			return Math.min(leftRst, rightRst);
		} else {
			if (delete)
				return 1;
			return 0;
		}

	}

}
