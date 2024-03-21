import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int length = Integer.parseInt(br.readLine());
		char[] data = br.readLine().toCharArray();

		int sum = 0;
		int storage = 0;

		for (int i = 1; i < length - 1; i++) {
			if (data[i - 1] == 'I' && data[i] == 'O' && data[i + 1] == 'I') {
				storage += 1;
				if (storage == n) {
					storage -= 1;
					sum += 1;
				}
				i++;
			} else {
				storage = 0;
			}
		}
		System.out.println(sum);
	}
}