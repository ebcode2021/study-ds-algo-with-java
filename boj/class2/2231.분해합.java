import java.io.*;

class Main {
	private static int sumEachNum(int num) {
		int res = 0;

		while (num > 0) {
			res += num % 10;
			num /= 10;
		}

		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int input = Integer.parseInt(br.readLine());

		int N = 1;
		boolean flag = false;
		while (N <= 1000000) {
			if (input == N + sumEachNum(N)) {
				flag = true;
				break ;
			}
			N++;
		}

		System.out.println(flag ? N : 0);
	}
}