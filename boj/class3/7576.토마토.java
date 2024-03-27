import java.io.*;
import java.util.*;

class Main {
	static int[][] boxs;
	static int row;
	static int col;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static int checkValue() {
		int max = 0; 

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (boxs[i][j] == 0) {
					return -1;
				}
				max = Math.max(max, boxs[i][j]);
			}
		}
		return max - 1;
	}

	public static int spreadTomato(Deque<int[]> deque) {

		while (!deque.isEmpty()) {
			int[] current = deque.poll();
			int x = current[0];
			int y = current[1];

			for (int j = 0; j < 4; j++) {
				int curX = x + dx[j];
				int curY = y + dy[j];

				if (curX < 0 || curX > row - 1 || curY < 0 || curY > col - 1) {
					continue ;
				}

				if (boxs[curX][curY] == 0) {
					deque.add(new int[]{curX, curY});
					boxs[curX][curY] = boxs[x][y] + 1;
				}
			}
		}

		return checkValue();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		col = input[0];
		row = input[1];
		boxs = new int[row][col];

		Deque<int[]> deque = new LinkedList<>();
		for (int i = 0; i < boxs.length; i++) {
			int[] datas = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			for (int j = 0; j < datas.length; j++) {
				boxs[i][j] = datas[j];
				if (datas[j] == 1) {
					deque.add(new int[]{i, j});
				}
			}
		}
		System.out.println(spreadTomato(deque));
	}
}