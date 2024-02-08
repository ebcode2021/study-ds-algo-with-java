import java.io.*;
import java.util.*;

class Main {

	private static int factorial(int n, int limit) {
		if (limit == 0)
			return 1;
		return n * factorial(n - 1, limit - 1);
	}

	private static int combine(int n, int k) {
		return factorial(n, k) / factorial(k, k);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		k = (n - k) < k ? (n - k) : k;

		if (k == 0)
			System.out.println(1);
		else {
			System.out.println(combine(n, k));
		}

	}
}