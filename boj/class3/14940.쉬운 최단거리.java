import java.io.*;
import java.util.*;

class Main {
	static int[][] maps;
	static boolean[][] visited;
	static int row, col;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void notArrived() {
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length; j++) {
				if (visited[i][j] == false && maps[i][j] != 0)
					maps[i][j] = -1;
			}
		}
	}
	public static void bfs(int x, int y) {
		Deque<int[]> deque = new LinkedList<>();
		deque.add(new int[]{x, y});
		maps[x][y] = 0;
		visited[x][y] = true;

		while(!deque.isEmpty()) {
			int[] dot = deque.poll();
			x = dot[0];
			y = dot[1];

			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
					continue;
				}

				if (maps[nextX][nextY] == 0 || visited[nextX][nextY] == true) {
					continue;
				}
				
				maps[nextX][nextY] = maps[x][y] + 1;
				visited[nextX][nextY] = true;
				deque.add(new int[]{nextX, nextY});
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		row = input[0];
		col = input[1];

		maps = new int[row][col];
		visited = new boolean[row][col];
		int x = 0, y = 0;

		for (int i = 0; i < row; i++){
			int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < data.length; j++) {
				maps[i][j] = data[j];
				if (data[j] == 2) {
					x = i;
					y = j;
				}
			}
		}

		bfs(x, y);

		notArrived();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				sb.append(maps[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}