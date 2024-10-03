import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coinTypeArr = new int[N];
		for (int i = 0; i < N; i++) {
			coinTypeArr[i] = Integer.parseInt(br.readLine());
		}

		int remain = K;
		int coinCnt = 0;
		for (int i = N - 1; i >= 0; i--) {
			int num = remain / coinTypeArr[i];
			if (num != 0) {
				coinCnt += num;
				remain -= coinTypeArr[i] * num;
			}
		}
		System.out.println(coinCnt);
	}
}