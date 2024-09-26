import java.io.*;
import java.util.*;

/**
 * 0층부터 살고, 각 층은 1호부터 있음. 0층의 i호에는 i명이 산다
 * a층의 b호에 살려면 (a-1)층의 1호부터 b호까지사람들의 수의 합만큼 데려와 살아야 한다.
 */
class Main {

	static int[][] apartArr = new int[15][15];

	static int getApart(int floor, int num) {
		int sum = 0;

		for (int i = 1; i <= num; i++) {
			sum += apartArr[floor][i];
		}

		return sum;
	}

	static void insertApart() {
		// 0층 입주
		for (int i = 1; i < 15; i++) {
			apartArr[0][i] = i;
		}

		// 1층 - 14층 입주
		for (int i = 1; i < 15; i++) {
			for (int j = 1; j< 15; j++) {
				apartArr[i][j] = getApart(i - 1, j);
			}
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());

		insertApart();

		while (testCase-- > 0) {
			int floor = Integer.parseInt(br.readLine());
			int num = Integer.parseInt(br.readLine());

			System.out.println(apartArr[floor][num]);
		}
	}
}