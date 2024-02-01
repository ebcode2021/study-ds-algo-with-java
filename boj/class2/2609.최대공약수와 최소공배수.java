import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());

		// 최대공약수 출력
		int max = num1 > num2 ? num1 : num2;
		int res1 = 0, res2 = 0;
		for (int i = max; i >=1; i--) {
			if (num1 % i == 0 && num2 % i == 0) {
				res1 = i;
				break ;
			}
		}
		// 최소공배수 출력
		for (int i = 1; i < 100000000; i++) {
			int tmp = res1 * i;
			if (tmp % num1 == 0 && tmp % num2 == 0) {
				res2 = tmp;
				break;
			}
		}

		System.out.println(res1);
		System.out.println(res2);
	}
}