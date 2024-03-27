import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] distinctArr = Arrays.stream(arr).distinct().toArray();
		Arrays.sort(distinctArr);

		int size = distinctArr.length;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < size; i++) {
			map.put(distinctArr[i], i);
		}

		for (int i = 0; i < num; i++) {
			sb.append(map.get(arr[i]) + " ");
		}
		System.out.print(sb);
		br.close();
	}
}