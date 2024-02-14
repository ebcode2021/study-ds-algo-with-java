import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		while(n-- > 0) {
			int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			LinkedList<int[]> q = new LinkedList<>();
			
			int testCase = data[0];
			int idx = data[1];
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int i = 0; i < testCase; i++) { // 초기위치와 중요도
				q.offer(new int[] {i, input[i]});
			}

			int count = 0;
			while (!q.isEmpty()) {
				int[] front = q.poll();
				boolean isMax = true;

				for (int i = 0; i < q.size(); i++) {
					if (front[1] < q.get(i)[1]) {
						q.offer(front);
						for(int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						isMax = false;
						break ;
					}
				}

				if (isMax == false) {
					continue;
				}

				count++;
				if (front[0] == idx) {
					break ;
				}
			}
			bw.append(count + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
