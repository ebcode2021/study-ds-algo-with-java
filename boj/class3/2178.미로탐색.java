import java.io.*;
import java.util.*;

/**
 * DFS 문제로 추측
 * 
 * N(행), M(열)
 * 예외 사항은 없읆
 */
class Main {
	static int[][] maps;
	static int row, col;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void bfs() {
		Deque<int[]> deque = new LinkedList<>();
		deque.add(new int[] {0, 0});

		while (!deque.isEmpty()) {
			int[] now = deque.poll();
			int nowX = now[0];
			int nowY = now[1];

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
					continue;
				}
				if (visited[nextX][nextY] == true || maps[nextX][nextY] == 0) {
					continue;
				}

				deque.add(new int[] {nextX, nextY});
				maps[nextX][nextY] = maps[nowX][nowY] + 1;
				visited[nextX][nextY] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		row = input[0];
		col = input[1];

		maps = new int[row][col];
		visited = new boolean[row][col];
		visited[0][0] = true;

		for (int i = 0; i < row; i ++) {
			String line = br.readLine();
			for (int j = 0; j < col; j++) {
				maps[i][j] = line.charAt(j) - '0';
			}
		}
		bfs();
		System.out.println(maps[row - 1][col - 1]);
	}
}