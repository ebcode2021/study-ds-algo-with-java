import java.io.*;
import java.util.*;

/**
 * 크기가 N * N 인 그리드
 * 각 칸은 -> R G B
 * return 적록색약이 아닌 사람이 봤을 때랑, 적록색약인 사람이 봤을 때
 */
class Main {
	static int N;
	static char[][] maps;
	static boolean[][] showVisited;
	static boolean[][] nonShowVisited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void showDFS(int row, int col) {
		char currentChar = maps[row][col];
		showVisited[row][col] = true;
		
		for (int i = 0; i < 4; i++) {
			int nextRow = row + dx[i];
			int nextCol = col + dy[i];
			
			if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
				continue;
			}
			if (showVisited[nextRow][nextCol] == false && currentChar == maps[nextRow][nextCol]) {
				showDFS(nextRow, nextCol);
			}
		}
	}

	public static void nonShowDFS(int row, int col) {
		char currentChar = maps[row][col];
		nonShowVisited[row][col] = true;
		
		for (int i = 0; i < 4; i++) {
			int nextRow = row + dx[i];
			int nextCol = col + dy[i];
			
			if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
				continue;
			}

			if (nonShowVisited[nextRow][nextCol] == false) {
				if ((currentChar == 'B' && currentChar == maps[nextRow][nextCol]) ||
					(currentChar != 'B' && maps[nextRow][nextCol] != 'B')) {
						nonShowDFS(nextRow, nextCol);
				} 
			}
		}
	} 


	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		maps = new char[N][N];
		showVisited = new boolean[N][N];
		nonShowVisited = new boolean[N][N];

		// map 초기화
		for (int i = 0; i < N; i++) {
			char[] data = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				maps[i][j] = data[j];
			}
		}

		// 정상인
		int showCnt = 0;
		int nonShowCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (showVisited[i][j] == false) {
					showDFS(i, j);
					showCnt++;
				}
				if (nonShowVisited[i][j] == false) {
					nonShowDFS(i, j);
					nonShowCnt++;
				}
			}
		}
		
		System.out.println(showCnt + " " + nonShowCnt);
		br.close();
	}
}