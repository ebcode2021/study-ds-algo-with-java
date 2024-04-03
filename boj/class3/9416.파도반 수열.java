import java.io.*;
import java.util.*;

/** 문제 유형 : DP  d
 */
class Main {
	static long[] triArr = new long[101];

	public static void initArr() {
		triArr[1] = 1;
		triArr[2] = 1; 

		for (int i = 3; i < 101; i++) {
			triArr[i] = triArr[i - 2] + triArr[i - 3];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		initArr();
		while (testCase-- > 0) {
			int num = Integer.parseInt(br.readLine());
			sb.append(triArr[num] + "\n");
		}
		System.out.print(sb);
		br.close();
	}
}