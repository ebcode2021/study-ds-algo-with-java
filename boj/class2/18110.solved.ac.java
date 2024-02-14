import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int value = (int) Math.round(n * 0.15);

		double sum = 0;
		for (int i = value; i < n - value; i++) {
			sum += arr[i];
		}

		System.out.println((int)Math.round(sum / ( n - 2 * value)));

		br.close();
	}
}
