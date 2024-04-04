import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int testCnt = Integer.parseInt(br.readLine());
		while (testCnt-- > 0) {
			int personCnt = Integer.parseInt(br.readLine());
			int num = personCnt > 32 ? 33 : personCnt;

			String[] datas = new String[num];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < num; i++) {
				datas[i] = st.nextToken();
			}

			int min = Integer.MAX_VALUE;
			for (int i = 0; i < num; i++) {
				for (int j = i + 1; j < num; j++) {
					for (int k = j + 1; k < num; k++) {
						int cnt = 0;
						for (int m = 0; m < 4; m++) {
							cnt += datas[i].charAt(m) != datas[j].charAt(m) ? 1 : 0;
							cnt += datas[j].charAt(m) != datas[k].charAt(m) ? 1 : 0;
							cnt += datas[k].charAt(m) != datas[i].charAt(m) ? 1 : 0;
						}
						min = Math.min(min, cnt);
						if (min == 0)
							break;
					}
				}
			}
			sb.append(min + "\n");
		}

		System.out.print(sb);
		br.close();
	}
}