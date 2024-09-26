import java.io.*;
import java.util.*;

class Main {

	private static int getMax(int a, int b) {
		int min = a > b ? b : a;

		while (min > 0) {
			if (a % min == 0 && b % min == 0) {
				return min;
			}
			min--;
		}
		return 1;
	}

	private static int getMin(int a, int b) {
		int increaseA = 2;
		int increaseB = 2;

		int currentA  = a;
		int currentB = b;

		while (true) {

			if (currentA == currentB) {
				return currentA;
			}

			if (currentA < currentB) {
				currentA = a * increaseA++;
			} else {
				currentB = b * increaseB++;
			}

		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		// 최대 공약수
		System.out.println(getMax(a, b));
		
		// 최소 공배수
		System.out.println(getMin(a, b));
	}
}