import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// var
		int basketCnt;
		int changeCnt;

		// 첫 줄 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		basketCnt = Integer.parseInt(st.nextToken());
		changeCnt = Integer.parseInt(st.nextToken());

		// 바구니 초기화
		int[] baskets = new int[basketCnt];
		for(int i = 0; i < basketCnt; i++) {
			baskets[i] = i + 1;
		}

		for(int i = 0; i < changeCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int frontIdx = Integer.parseInt(st.nextToken()) - 1;
			int backIdx = Integer.parseInt(st.nextToken()) - 1;
			int half = (backIdx - frontIdx + 1) / 2;
			for (int j = 0; j < half; j++) {
				int tmp = baskets[frontIdx + j];
				baskets[frontIdx + j] = baskets[backIdx - j];
				baskets[backIdx - j] = tmp;
			}
		}
		for (int ball : baskets) {
			bw.write(ball + " ");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
