import java.io.*;
import java.util.*;

class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] map = new int[1001][1001]; // 저장할 배열
	static boolean[] visited = new boolean[1001]; // 방문 여부 확인 배열
	static int N;

	private static void dfs(int start) {
		visited[start] = true;
		sb.append(start + " ");
		for (int i = 1; i <= N; i++) {
			if (map[start][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
	}

	private static void bfs(int start) {
		Deque<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		sb.append("\n" + start + " ");

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (map[current][i] == 1 && visited[i] == false) {
					queue.add(i);
					visited[i] = true;
					sb.append(i + " ");
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = input[0];
		int routeCnt = input[1];
		int start = input[2];



		while (routeCnt-- > 0) {
			input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			map[input[0]][input[1]] = map[input[1]][input[0]] = 1;
		}

		dfs(start);
		Arrays.fill(visited, false);
		bfs(start);

		
		System.out.println(sb);
		br.close();
	}
}