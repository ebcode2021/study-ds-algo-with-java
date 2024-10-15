import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int num = Integer.parseInt(br.readLine());

		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new int[]{x, y});
		}

		Collections.sort(list, (l1, l2) -> {
			if (l1[1] == l2[1]) {
				return l1[0] - l2[0];
			}
			return l1[1] - l2[1];
		});

		for (int[] a : list) {
			bw.write(a[0] + " " + a[1] + "\n");
		}

		bw.flush();
		bw.close();
	}
}