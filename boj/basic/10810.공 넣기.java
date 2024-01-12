import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		int baskets;
		int balls;
		String readLine;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		readLine = br.readLine();

		StringTokenizer st = new StringTokenizer(readLine);
		baskets = Integer.parseInt(st.nextToken());
		balls = Integer.parseInt(st.nextToken());

		int[] result = new int[baskets];
		for (int i = 0; i < balls; i++) {
			readLine = br.readLine();
			st = new StringTokenizer(readLine);

			int startIdx = Integer.parseInt(st.nextToken());
			int endIdx = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());

			for (int j = startIdx - 1; j < endIdx; j++) {
				result[j] = ball;
			}
		}
		for (int value : result) {
			bw.write(value + " ");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}

class Main2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		int M = sc.nextInt();

		for(int i = 0; i < M; i++) {
			int I = sc.nextInt();
			int J = sc.nextInt();
			int K = sc.nextInt();

			for(int j = I - 1; j < J; j++) {
				arr[j] = K;
			}
		}
		for(int k = 0; k < arr.length; k++) {
			System.out.print(arr[k] + " ");
		}
	}
}