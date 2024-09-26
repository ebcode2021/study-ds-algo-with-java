import java.io.*;
import java.util.*;

class Main {

	private static boolean isPrime(int num) {
		if (num == 1) {
			return false;
		}

		int sqrt = (int)Math.sqrt(num);
		
		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int count = 0;
		while (N-- > 0) {
			int num = Integer.parseInt(st.nextToken());

			if (isPrime(num) == true) {
				count++;
			}
		}
		System.out.println(count);
	}
}