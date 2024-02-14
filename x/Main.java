import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));

		int n = Integer.parseInt(br.readLine());

		int[][] dots= new int[n][2];

		for (int i = 0; i < n; i++) {
			int[] dot = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			dots[i][0] = dot[0];
			dots[i][1] = dot[1];
		}

		Arrays.sort(dots, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		});

		for (int i = 0; i < n; i++) {
			bw.append(dots[i][0] + " " + dots[i][1] + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
