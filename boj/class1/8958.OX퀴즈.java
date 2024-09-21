import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCnt = Integer.parseInt(br.readLine());

		while (testCnt-- > 0) {
			char[] input = br.readLine().toCharArray();
			int increase = 1;
			int sum = 0;

			for (char c : input) {
				if (c == 'O') {
					sum += increase++;
				} else {
					increase = 1;
				}
			}

			bw.write(sum + "\n");
		}

		bw.flush();
		bw.close();
	}
}