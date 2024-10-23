class Solution {

	private String[][] map;

	private boolean canSpread(int size, int row, int col) {
		
		if (row + size > map.length || col + size > map[0].length) {
			return false;
		}
		
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (!map[i][j].equals("-1")) {
					return false;
				}
			}
		}
		return true;
	}

	public int solution(int[] mats, String[][] park) {
		int answer = -1;
		
		map = park;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j].equals("-1")) {
					for (int mat : mats) {
						if (canSpread(mat, i, j)) {
							answer = mat > answer ? mat : answer;
						}
					}
				}
			}
		}
		return answer;
	}
}