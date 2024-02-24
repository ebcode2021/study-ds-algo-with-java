import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int breakCnt = Integer.parseInt(br.readLine());

		boolean[] broken = new boolean[10];
		if (breakCnt > 0) {
			int[] brokenArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int i = 0; i < breakCnt; i++) {
				broken[brokenArr[i]] = true;
			}
		}

		int result = Math.abs(N - 100);

		for (int i = 0; i < 1000000; i++) {
			String current = String.valueOf(i);
			int len = current.length();

			boolean isBreak = false;
			for (int j = 0; j < len; j++) {
				if (broken[current.charAt(j) - '0']) {
					isBreak = true;
					break ;
				}
			}

			if (!isBreak) {
				int min = Math.abs(N - i) + len;
				result = Math.min(min, result);
			}
		}

		System.out.println(result);
	}
}