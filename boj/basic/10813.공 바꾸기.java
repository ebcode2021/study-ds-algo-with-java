import java.io.*;
import java.util.*;

class Main {
	private static void swap(int[] baskets, int frontIdx, int backIdx) {
		int tmpValue = baskets[frontIdx];
		baskets[frontIdx] = baskets[backIdx];
		baskets[backIdx] = tmpValue;
	}

	public static void main(String[] args) throws Exception {
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// var
		int basketCnt;
		int changeCnt;

		StringTokenizer st = new StringTokenizer(br.readLine());
		basketCnt = Integer.parseInt(st.nextToken());
		changeCnt = Integer.parseInt(st.nextToken());

		int[] baskets = new int[basketCnt];
		for (int i = 0; i < basketCnt; i++) {
			baskets[i] = i + 1;
		}

		while (changeCnt > 0) {
			st = new StringTokenizer(br.readLine());
			int frontIdx = Integer.parseInt(st.nextToken()) - 1;
			int backIdx = Integer.parseInt(st.nextToken()) - 1;
			swap(baskets, frontIdx, backIdx);
			changeCnt--;
		}

		for (int value : baskets) {
			bw.write(value + " ");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
