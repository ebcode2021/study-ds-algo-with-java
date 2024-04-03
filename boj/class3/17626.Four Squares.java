import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int[] dp = new int[num + 1];

		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= num; i++) {
			dp[i] = dp[i - 1];
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - (j * j)]);
			}
			dp[i]++;
		}

		System.out.println(dp[num]);

		br.close();
	}
}