import java.io.*;
import java.math.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String input = br.readLine();

			if (Integer.parseInt(input) == 0) {
				break;
			}

			char[] charArr = input.toCharArray();
			int len = charArr.length / 2;
			boolean flag = true;
			for (int i = 0; i < len; i++) {
				if (charArr[i] != charArr[charArr.length - 1 - i]) {
					flag = false;
				}
			}
			System.out.println(flag ? "yes" : "no");
		}
	}
}