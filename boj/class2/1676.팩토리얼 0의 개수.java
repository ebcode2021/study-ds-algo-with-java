import java.io.*;
import java.math.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		BigInteger big = new BigInteger("1");
		for (int i = 1; i <= num; i++) {
			big = big.multiply(BigInteger.valueOf(i));
		}

		String str = big.toString();
		int res = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == '0') {
				res += 1;
			} else {
				break;
			}
				
		}
		System.out.println(res);
	}
}