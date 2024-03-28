import java.io.*;
import java.util.*;

class Main {
	static boolean[][] visited;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] maps;
	static int N;

	public static int find(int row, int col) {
		Deque<int[]> deque = new LinkedList<>();
		deque.add(new int[]{row, col});
		
		int count = 0;
		while (!deque.isEmpty()) {
			int[] data = deque.poll();
			int x = data[0];
			int y = data[1];
			if (visited[x][y] == true) {
				continue;
			}
			visited[x][y] = true;
			count++;

			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
					continue;
				}
				if (visited[nextX][nextY] == false && maps[nextX][nextY] == 1) {
					deque.add(new int[]{nextX, nextY});
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		// 입력 데이터로 map 초기화
		maps = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] datas = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				maps[i][j] = datas[j] - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (maps[i][j] == 1 && visited[i][j] == false) {
					pq.add(find(i, j));
				}
			}
		}

		// 결과물 출력
		System.out.println(pq.size());
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}