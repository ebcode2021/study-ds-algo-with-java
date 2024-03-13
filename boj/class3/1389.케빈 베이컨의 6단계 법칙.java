import java.io.*;
import java.util.*;

class Main {
	static int min = 101;
	static int minPerson = 0;
	static int N;
	static boolean visited[];
	static int[][] map;

	private static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;

		int[] distance = new int[N + 1];
		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (map[current][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
					distance[i] = distance[current] + 1;
				}
			}
		}

		int totalDistance = 0;
		for (int i = 1; i <= N; i++) {
			totalDistance += distance[i];
		}

		return totalDistance;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		while (cnt-- > 0) {
			int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			map[data[0]][data[1]] = map[data[1]][data[0]] = 1;
		}

		for (int i = 1; i <= N; i++) {
			int distanceSum = bfs(i);
			if (distanceSum < min) {
				min = distanceSum;
				minPerson = i;
			}
			Arrays.fill(visited, false);
		}

		System.out.println(minPerson);
	}
}
