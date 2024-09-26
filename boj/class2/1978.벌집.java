import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int input = Integer.parseInt(br.readLine());
		
		int num = 1;
		int cnt = 1;

		while (num < input) {
			cnt++;
			num = 1 + 6 * (cnt * (cnt - 1) / 2);
		}
		
		System.out.println(cnt);


	}
}