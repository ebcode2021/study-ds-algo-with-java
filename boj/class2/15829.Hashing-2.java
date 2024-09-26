import java.io.*;
import java.math.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine());
		char[] charArr = br.readLine().toCharArray();

		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < charArr.length; i++) {
			sum = sum.add(BigInteger.valueOf(charArr[i] - 'a' + 1).multiply(BigInteger.valueOf(31).pow(i)));
		}

		sum = sum.mod(BigInteger.valueOf(1234567891));
		System.out.println(sum);
	}
}