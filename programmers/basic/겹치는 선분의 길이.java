class Solution {
	public int solution(int[][] lines) {
		int[] duplicateList = new int[201];
		int result = 0;

		for (int[] line : lines) {
			for (int i = line[0]; i < line[1]; i++) {
				duplicateList[i + 100] += 1;
			}
		}
		
		for (int i = 0; i < 200; i++) {
			if (duplicateList[i] > 1)
				result += 1;
		}
		return result;
	}
}