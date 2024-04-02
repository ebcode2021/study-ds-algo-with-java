import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {
			int cnt = Integer.parseInt(br.readLine());

			Map<String, Integer> clohtes = new HashMap<>();
			for (int i = 0; i < cnt; i++) {
				String[] cloth = br.readLine().split(" ");
				clohtes.put(cloth[1], clohtes.getOrDefault(cloth[1], 0) + 1);
			}

			int result = 1;

			for (int value : clohtes.values()) {
				result *= (value + 1);
			}
			sb.append((result - 1) + "\n");
		}
		
		System.out.print(sb);
		br.close();
	}
}