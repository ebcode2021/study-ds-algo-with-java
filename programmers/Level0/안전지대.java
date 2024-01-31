class Solution {
	static boolean isSafe(int[][] board, int row, int col) {
		int size = board.length - 1;
		
		int startRow = row - 1 < 0 ? 0 : row - 1;
		int endRow = row + 1 > size ? size : row + 1;
		int startCol = col - 1 < 0 ? 0 : col - 1;
		int endCol = col + 1 > size ? size : col + 1;

		for (int i = startRow; i <= endRow; i++) {
			for (int j = startCol; j <= endCol; j++)
				if (board[i][j] == 1)
					return true;
		}
		return false;
	}

	// n * n 으로 들어오는 크기의 board
	public int solution(int[][] board) {
		int answer = 0;
		int size = board.length;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board[i][j] == 0 && isSafe(board, i, j) == false) {
					answer++;
				}
			}
		}
		return answer;
	}
}