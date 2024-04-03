import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int siteCnt = Integer.parseInt(st.nextToken());
		int findCnt = Integer.parseInt(st.nextToken());

		Map<String, String> memos = new HashMap<>();
		while (siteCnt-- > 0) {
			st = new StringTokenizer(br.readLine());
			memos.put(st.nextToken(), st.nextToken());
		}

		while (findCnt-- > 0){
			String site = br.readLine();
			sb.append(memos.get(site) + "\n");
		}
		System.out.print(sb);
		br.close();
	}
}