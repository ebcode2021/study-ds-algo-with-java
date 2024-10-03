import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (a1, a2) -> {
            return a1[1] != a2[1] ? a1[1] - a2[1] : a1[0] - a2[0];
        });

		int res = 1;
		int endTime = arr[0][1]; // 가장 빨리 끝나는 시간
		for (int i = 1; i < N; i++) {
			if (arr[i][0] >= endTime) {
				endTime = arr[i][1];
				res++;
			}
		}

		System.out.println(res);
	}
}