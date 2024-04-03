import java.io.*;
import java.util.*;

class Main {
	static char[][] maps;
	static boolean[][] visited;
	static int row;
	static int col;
	static int person = 0;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void dfs(int curRow, int curCol) {
		visited[curRow][curCol] = true;

		if (maps[curRow][curCol] == 'P') {
			person++;
		}
		
		for (int i = 0; i < 4; i++) {
			int newRow = curRow + dx[i];
			int newCol = curCol + dy[i];


			if (newRow < 0 || newRow >= row || newCol < 0 || newCol >= col) {
				continue;
			}

			if (visited[newRow][newCol] == false && maps[newRow][newCol] != 'X') {
				dfs(newRow, newCol);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		maps = new char[row][col];
		visited = new boolean[row][col];

		int startRow = 0, startCol = 0;
		for (int i = 0; i < row; i++) {
			char[] data = br.readLine().toCharArray();
			for (int j = 0; j < col; j++) {
				maps[i][j] = data[j];
				if (data[j] == 'I') {
					startRow = i;
					startCol = j;
				}
			}
		}
		dfs(startRow, startCol);
		if (person == 0) {
			sb.append("TT");
		} else {
			sb.append(person);
		}
		System.out.println(sb);
		br.close();
	}
}