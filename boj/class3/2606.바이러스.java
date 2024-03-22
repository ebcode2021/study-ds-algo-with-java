import java.io.*;
import java.util.*;

class Main {

	static Map<Integer, List<Integer>> map = new HashMap<>();
	static boolean[] visited;

	public static int bfs() {

		Deque<Integer> deque = new LinkedList<>();
		deque.offer(1);
		visited[1] = true;
		int result = 0;
		while (!deque.isEmpty()) {
			int computerNum = deque.poll();
			List<Integer> list = map.get(computerNum);
			if (list == null) {
				continue;
			}
			for (int location : list) {
				if (visited[location] == true) {
					continue;
				}
				deque.offer(location);
				visited[location] = true;
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int computerCnt = Integer.parseInt(br.readLine());
		visited = new boolean[computerCnt + 1];
		int line = Integer.parseInt(br.readLine());

		while (line-- > 0) {
			int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			map.putIfAbsent(data[0], new ArrayList<>());
			map.putIfAbsent(data[1], new ArrayList<>());
			map.get(data[0]).add(data[1]);
			map.get(data[1]).add(data[0]);
		}

		System.out.println(bfs());
	}
}