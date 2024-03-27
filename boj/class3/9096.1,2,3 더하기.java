import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] results = new int[11];

		results[1] = 1;
		results[2] = 2;
		results[3] = 4;
		for (int i = 4; i < 11; i++) {
			results[i] = results[i - 1] + results[i - 2] + results[i - 3];
		}

		while (n-- > 0) {
			sb.append(results[Integer.parseInt(br.readLine())] + "\n");
		}

		System.out.print(sb);

		br.close();
	}
}

