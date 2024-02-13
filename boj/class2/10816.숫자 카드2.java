import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Map<Integer, Integer> storage = new HashMap<>();

		int N = Integer.parseInt(br.readLine());
		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		for (int i = 0; i < N; i++) {
			storage.put(nums[i], storage.getOrDefault(nums[i], 0) + 1);
		}

		int M = Integer.parseInt(br.readLine());
		int[] nums2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		for (int i = 0; i < M; i++) {
			bw.append(storage.getOrDefault(nums2[i], 0) + " ");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
