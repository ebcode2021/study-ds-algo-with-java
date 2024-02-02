import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 정렬된 nList 생성
		
		int n = Integer.parseInt(br.readLine());
		int[] nList = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nList[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nList);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (Arrays.binarySearch(nList, num) < 0) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		}
	}
}