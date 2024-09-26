import java.io.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int input = Integer.parseInt(br.readLine());
			
		int result = 0;
		for (int i = 1; i < input; i++) {
			int current = i;
			char[] charArr = String.valueOf(current).toCharArray();

			for (char c : charArr) {
				current += (c - '0');
			}

			if (current == input) {
				result = i;
				break;
			}
		}

		System.out.println(result);
	}
}