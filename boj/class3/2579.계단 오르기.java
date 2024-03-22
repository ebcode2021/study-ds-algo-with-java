import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		Integer[] dp = new Integer[num + 1];
		int[] arr = new int[num + 1];

		for (int i = 1; i <= num; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 0;
		dp[1] = arr[1];

		if (num >= 2) {
			dp[2] = arr[1] + arr[2];
		}

		for (int i = 3; i <= num; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
		}

		System.out.println(dp[num]);
	}	
}