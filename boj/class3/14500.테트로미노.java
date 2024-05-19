import java.io.*;
import java.util.*;


/**
 * [조건]
 * - 도형은 겹치면 안된다.
 * 
 * 폴리오미노 : 정사각형 4개를 이어 붙인 것
 * 
 * 완전 탐색..?
 */

class Main {

	static int row;
	static int col;
	static int[][] maps;
	static boolean[][] visited;
	static int max = 0;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	private static void findMaxValue(int curRow, int curCol, int cnt, int result) {
		if (cnt == 4) {
			max = Math.max(max, result);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextRow = curRow + dx[i];
			int nextCol = curCol + dy[i];

			if (nextRow < 0 || nextRow > row - 1 || nextCol < 0 || nextCol > col - 1) {
				continue;
			}

			if (visited[nextRow][nextCol] == true) {
				continue;
			}

			if (cnt == 2) {
				visited[nextRow][nextCol] = true;
				findMaxValue(curRow, curCol, cnt + 1, result + maps[nextRow][nextCol]);
				visited[nextRow][nextCol] = false;
			}
			visited[nextRow][nextCol] = true;
			findMaxValue(nextRow, nextCol, cnt + 1, result + maps[nextRow][nextCol]);
			visited[nextRow][nextCol] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// initialize row, col
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		// initialize map, visited
		maps = new int[row][col];
		visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			maps[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				visited[i][j] = true;
				findMaxValue(i, j, 1, maps[i][j]);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
	}
}