import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Map<Integer, Integer> map = new HashMap<>();
		int maxLength = 0;
		int left = 0;
		for (int right = 0; right < N; right++) {
			map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

			while (map.size() > 2) {
				map.put(arr[left], map.get(arr[left]) - 1);
				if (map.get(arr[left]) == 0) {
					map.remove(arr[left]);
				}
				left++;
			}
			maxLength = Math.max(maxLength, right - left + 1);
		}
		System.out.println(maxLength);
	}
}