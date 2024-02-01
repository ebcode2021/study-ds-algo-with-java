import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] nums = br.readLine().split(" ");
		int sum = 0;

		for (String num : nums) {
			int n = Integer.parseInt(num);
			sum += n * n;
		}
		System.out.println(sum % 10);
		br.close();
	}
}