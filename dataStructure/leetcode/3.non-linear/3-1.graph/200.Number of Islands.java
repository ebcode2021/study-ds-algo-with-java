/**
 * [1, 1, 1, 1, 0]
 * [1, 1, 0, 1, 0]
 * [1, 1, 0, 0, 0]
 * [0, 0, 0, 0, 1]
 */

class Solution {
	public void dfs(int i, int j, char[][] grid) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
			return ;
		// 한 번만 탐색하기 위해 탐색한 지점은 물(0)로 변경
		grid[i][j] = '0';
		// 동서남북 재귀 DFS
		dfs(i, j + 1, grid); // 동
		dfs(i, j - 1, grid); // 서
		dfs(i + 1, j, grid); // 남
		dfs(i - 1, j, grid); // 북
		
	}

	public int numIslands(char[][] grid) {
		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				// 만약 육지가 [1]인 경우 DFS
				if (grid[i][j] == '1') {
					dfs(i, j, grid);
					count++;
				}
			}
		}
		return count;
	}
}