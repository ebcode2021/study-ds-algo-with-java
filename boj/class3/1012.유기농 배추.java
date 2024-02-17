import java.io.*;
import java.util.*;

class Main {

	private static void dfs(int[][] map, int row, int col) {
		if (row < 0 || row >= map.length || col < 0 || col >= map[0].length || map[row][col] == 0) {
			return;
		}

		map[row][col] = 0;

		dfs(map, row - 1, col);
		dfs(map, row + 1, col);
		dfs(map, row, col - 1);
		dfs(map, row, col + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0){
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			int col = input[0];
			int row = input[1];
			int[][] map = new int[row][col];
			int vegCnt = input[2];

			for (int i = 0; i < vegCnt; i++) {
				int[] dot = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				map[dot[1]][dot[0]] = 1; 
			}

			int count = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (map[i][j] == 1) {
						dfs(map, i, j);
						count++;
					}
				}
			}
			bw.write(count + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}