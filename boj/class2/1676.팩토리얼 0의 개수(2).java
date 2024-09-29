import java.io.*;
import java.math.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		BigDecimal bigDecimal = new BigDecimal("1");

		for (int i = 2; i <= num; i++) {
			bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(i));
		}

		String str = bigDecimal.toString();
		int result = 0;

		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == '0') {
				result++;
			} else {
				break;
			}
		}
		System.out.println(result);
	}
}