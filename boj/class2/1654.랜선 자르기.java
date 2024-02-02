import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N= Integer.parseInt(st.nextToken());

		// 랜선들을 담는 리스트
		List<Integer> lanCables = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			lanCables.add(Integer.parseInt(br.readLine()));
		}

		// 초기값 세팅
		long low = 1;
		long high = Collections.max(lanCables);

		while (low <= high) {
			long mid = (low + high) / 2;
			long count = 0;

			for (Integer cable : lanCables) {
				count += cable / mid;
			}

			if (count >= N) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(high);
	}
}