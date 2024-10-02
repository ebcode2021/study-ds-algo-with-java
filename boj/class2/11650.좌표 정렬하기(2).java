import java.io.*;
import java.util.*;

/**
 * 좌표 x 증가방향. x가 같으면 y가 증가
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[][] spot = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			spot[i][0] = Integer.parseInt(st.nextToken());
			spot[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(spot, (s1, s2) -> {
			return s1[0] == s2[0] ? s1[1] - s2[1] : s1[0] - s2[0];
		});

		for (int i = 0 ; i < N; i++) {
			bw.write(spot[i][0] + " " + spot[i][1] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
		
	}
}