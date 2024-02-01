import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 정수 N개로 이루어짐
		int n = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());

		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		for (int num : nums) {
			if (num < max)
				bw.append(num + " ");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}