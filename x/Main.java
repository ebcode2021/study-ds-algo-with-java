import java.io.*;
import java.util.*;

/**
 * m x n x h 의 상자들
 * 익은 토마토는 인접한 곳에 있는 토마토에게 영향을 주고
 * 며칠이 지나면 다 익게 되는지 최소 일수. (만약, 이미 전부 익어있으면 0, 익지 못하면 -1)
 * 1은 익은거. 0은 안익은거. -1은 없는거
 * 
 * 문제풀이 : BFS or DFS 풀이 가능. 나는 BFS로 풀이
 */

class Point {
	int x;
	int y;
	int z;

	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

class Main {
	static int[][][] box;
	static boolean[][][] visited;
	static int row, col, height;
	static int max = 0;
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static Deque<Point> deque = new LinkedList<>();


	public static boolean isDoneTomato() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < row; j++) {
				for (int k = 0; k < col; k++) {
					if (box[j][k][i] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void bfs() {
		while (!deque.isEmpty()) {
			for (int i = 0; i < deque.size(); i++) {
				Point point = deque.poll();
				visited[point.x][point.y][point.z] = true;
				for (int j = 0; j < 6; j++) {
					int nextRow = point.x + dx[j];
					int nextCol =  point.y + dy[j];
					int nextHeight = point.z + dz[j];
					if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col || nextHeight < 0 || nextHeight >= height) {
						continue;
					} else if (visited[nextRow][nextCol][nextHeight] == true || box[nextRow][nextCol][nextHeight] != 0) {
						continue;
					}
					box[nextRow][nextCol][nextHeight] = box[point.x][point.y][point.z] + 1;
					max = box[nextRow][nextCol][nextHeight] > max ? box[nextRow][nextCol][nextHeight] : max;
					deque.add(new Point(nextRow, nextCol, nextHeight));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// row, col, height 초기화
		st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
	
		// 배열 초기화
		box = new int[row][col][height];
		visited= new boolean[row][col][height];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < row; j++) {
				int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				for (int k = 0; k < col; k++) {
					box[j][k][i] = data[k];
					if (data[k] == 1) {
						deque.add(new Point(j, k, i));
					}
				}
			}
		}

		
		// 이미 모두 익은 토마트 그룹인지
		if (isDoneTomato() == true) {
			System.out.println(0);
			return ;
		} 
		
		bfs();

		// 숙성이 안된 토마토가 있는지
		if (isDoneTomato() == false) {
			System.out.println(-1);
		} else {
			System.out.println(max - 1);
		}

		br.close();
	}
}