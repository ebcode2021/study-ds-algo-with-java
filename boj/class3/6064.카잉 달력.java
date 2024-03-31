import java.io.*;
import java.util.*;

class Main {

	public static int gcd(int a, int b) {
		while (b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}

	public static int checkYear(int M, int N, int x, int y) {

		if (x == 1 && y == 1) {
			return 1;
		}

		int count = x;
		int start = x;
		int end = (x % N  > 0) ? x % N : N;
		long maxCount = (long)(M * N) / gcd(M, N);

		while (count <= maxCount) {

			if (start == x && end == y) {
				return count;
			}
			count += M;
			end = (end + M) % N;
			if (end == 0) {
				end = N;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException { //5430
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int count = Integer.parseInt(br.readLine());

		while (count-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			sb.append(checkYear(M, N, x, y) + "\n");
		}

		System.out.print(sb);
		br.close();
	}
}