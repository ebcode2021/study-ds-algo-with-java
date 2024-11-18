import java.io.*;
import java.util.*;

/**
 * (몸무게, 키) // 몸무게, 키 둘다 클 때 더 크다.
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int weight = 0;
		int tall = 1;
		
		int num = Integer.parseInt(br.readLine());

		int[][] arr = new int[num][2];
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][weight] = Integer.parseInt(st.nextToken());
			arr[i][tall] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < num; i++) {
			int rank = 1;
			for (int j = 0; j < num; j++) {
				if (i != j) {
					if (arr[i][weight] < arr[j][weight] && arr[i][tall] < arr[j][tall]) {
						rank++;
					} 
				}
			}
			bw.append(rank + " ");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}