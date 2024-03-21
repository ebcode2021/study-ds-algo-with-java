import java.io.*;
import java.util.*;

/**
 * 명단 1과 명단 2가 주어지고
* -> 명단 1과 명단 2에 duplicate가 되는 것을 출력
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 명단 1, 명단 2의 각 개수 받아오기
		int[] personCnt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Set<String> set = new HashSet<>();
		
		// 명단 1에 대해 저장
		for (int i = 0; i < personCnt[0]; i++) {
			set.add(br.readLine());
		}

		ArrayList<String> results = new ArrayList<>();
		for (int i = 0; i < personCnt[1]; i++) {
			String name = br.readLine();
			if (set.contains(name)) {
				results.add(name);
			}
		}

		Collections.sort(results);

		bw.append(results.size() + "\n");
		for (String result : results) {
			bw.append(result + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}