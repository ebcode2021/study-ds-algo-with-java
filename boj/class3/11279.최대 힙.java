import java.io.*;
import java.util.*;

/**
 * 숫자가 양수라면 추가하는 연산.
 * 숫자가 0이라면 가장 큰 값을 추출하고 그 값을 배열에서 제거하는 경우
 */
class Main {
	
	public static void main(String[] args) throws IOException { //5430
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		while (count-- > 0) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				if (pq.size() == 0) {
					sb.append(0 + "\n");
				} else {
					sb.append(pq.poll() + "\n");
				}
			} else {
				pq.offer(num);
			}
		}

		System.out.print(sb);
		br.close();
	}
}