import java.io.*;
import java.util.*;

/**
 * 문제 유형 : BFS?
 * 1은 파란색 0은 하얀색
 * return -> 하얀색 색종이 수 + \n + 파란색 색종이 수
 */
class Main {
	static int[][] maps;
	static int whiteCnt = 0;
	static int blueCnt = 0;

	public static void bfs(int row, int col, int length) {
		int value = maps[row][col];

		if (length > 1) {
			for (int i = row; i < row + length; i++) {
				for (int j = col; j < col + length; j++) {
					if (value != maps[i][j]) {
						int curLength = length / 2;
						bfs(row, col, curLength);
						bfs(row + curLength, col, curLength);
						bfs(row, col + curLength, curLength);
						bfs(row + curLength, col + curLength, curLength);
						return ;
					}
				}
			}
		}

		if (value == 1) {
			blueCnt++;
		} else {
			whiteCnt++;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int length = Integer.parseInt(br.readLine());

		maps = new int[length][length];
		for (int i = 0; i < length; i++) {
			maps[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		bfs(0, 0, length);

		System.out.println(whiteCnt + "\n" + blueCnt);
	}
}