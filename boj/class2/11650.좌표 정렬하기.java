import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<int[]> list = new ArrayList<>();

		int dotCnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < dotCnt; i++) {
			int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			list.add(nums);
		}

		list.sort((o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		for(int[] data : list) {
			bw.append(data[0] + " " + data[1] + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
