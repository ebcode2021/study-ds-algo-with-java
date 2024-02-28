import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int pokemonCnt = Integer.parseInt(st.nextToken());
		int problemCnt = Integer.parseInt(st.nextToken());

		Map<Integer, String> indexMap = new HashMap<>();
		Map<String, Integer> nameMap = new HashMap<>();

		for (int i = 0; i < pokemonCnt; i++) {
			String name = br.readLine();
			indexMap.put(i + 1, name);
			nameMap.put(name, i + 1);
		}

		while (problemCnt-- > 0) {
			String input = br.readLine();

			if (Character.isDigit(input.charAt(0))) {
				sb.append(indexMap.get(Integer.parseInt(input)) + "\n");
			} else {
				sb.append(nameMap.get(input) + "\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}