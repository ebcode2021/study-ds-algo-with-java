import java.io.*;
import java.math.BigInteger;

/**
 * 해시함수 : 고정된 길이의 출력을 내보내는 함수(자료 저장 + 탐색)
 * ascii : a = 97
 * r은 31, M은 1234567891
 */
class Main {
	private static final int R = 31;
	private static final int MOD = 1234567891;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int len = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();

		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < len; i++) {
			BigInteger term = BigInteger.valueOf(input[i] - 96).multiply(BigInteger.valueOf(R).pow(i));
			sum = sum.add(term);
		}

		sum = sum.mod(BigInteger.valueOf(MOD));
		System.out.println(sum);
	}
}
