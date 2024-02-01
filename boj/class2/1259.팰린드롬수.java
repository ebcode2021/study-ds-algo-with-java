import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		while (!input.equals("0")) {
			char[] inputList = input.toCharArray();
			int lastIdx = inputList.length - 1;
			int mid = inputList.length / 2;
			boolean flag = true;

			for (int i = 0; i < mid; i++) {
				if (inputList[i] != inputList[lastIdx - i]) {
					flag = false;
					break ;
				}
			}
			String res = flag ? "yes" : "no";
			System.out.println(res);
			input = br.readLine();
		}
	}
}