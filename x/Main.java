import java.io.*;
import java.util.*;

/**
 * 키, 몸무게가 모두 커야 덩치가 더 큰 사람으로 인정
 * (x, y) , (p, q) -> x > p, y > q 여야 성립
 * 범위가 적은 걸로 보아 브루트포스
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] rankArr = new int[N];
		for (int i = 0; i < N; i++) {
			int ranking = 1;
			for (int j = 0; j < N; j++) {
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					ranking++;
				}
			}
			rankArr[i] = ranking;
		}

		for (int i = 0; i< N; i++) {
			bw.write(rankArr[i] + " ");
		}

		bw.flush();
		bw.close();
	}
}