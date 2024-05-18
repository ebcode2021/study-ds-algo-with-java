import java.io.*;
import java.util.*;

/**
 * D : n을 2배로 바꾼다. 10000이 넘으면 나머지로
 * S : n에서 1을 뺀 결과를 저장. n=0이라면 9999가 저장
 * L : n의 각 자릿수를 왼편으로 회전. d2, d3, d4, d1
 * R : n의 각 자릿수를 오른편으로 회전. d4, d1, d2, d3
 * 
 * A를 B로 바꾸는 최소한의 명령어 생성
 * 1234 -> 2341 -> 3412
 * 
 * 문제는 Queue..? + BFS
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			Queue<Integer> queue = new LinkedList<>();
			boolean[] visited = new boolean[10000];
			String[] commands = new String[10000];

			queue.add(a);
			visited[a] = true;
			Arrays.fill(commands, "");

			while (!queue.isEmpty() && !visited[b]) {
				int now = queue.poll();

				int D = (2 * now) % 10000;
				int S = now == 0 ? 9999 : now - 1;
				int L = (now % 1000) * 10 + now / 1000;
				int R = (now % 10) * 1000 + now / 10;

				if (!visited[D]) {
					queue.add(D);
					visited[D] = true;
					commands[D] = commands[now] + "D";
				}

				if (!visited[S]) {
					queue.add(S);
					visited[S] = true;
					commands[S] = commands[now] + "S";
				}

				if (!visited[L]) {
					queue.add(L);
					visited[L] = true;
					commands[L] = commands[now] + "L";
				}

				if (!visited[R]) {
					queue.add(R);
					visited[R] = true;
					commands[R] = commands[now] + "R";
				}
			}
			System.out.println(commands[b]);
		}
	}
}