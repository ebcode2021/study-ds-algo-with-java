import java.io.*;
import java.util.*;

class Main {
	static int[] dp;

	public static void initDp(int[] arr) {
		for (int i = 2; i < arr.length + 1; i++) {
			dp[i] = dp[i - 1] + arr[i - 1];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int num = input[0];
		int cnt = input[1];

		int[] arr = new int[num + 1];
		arr =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		dp = new int[num + 1];
		dp[0] = 0;
		dp[1] = arr[0];
		
		initDp(arr);

		for (int i = 0; i < cnt; i++) {
			int[] index = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int startIdx = index[0];
			int endIdx = index[1];
			sb.append(dp[endIdx] - dp[startIdx - 1] + "\n");
		}

		System.out.print(sb);
		br.close();
	}
}