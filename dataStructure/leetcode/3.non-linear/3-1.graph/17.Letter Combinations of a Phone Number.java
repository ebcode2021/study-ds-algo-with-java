import java.util.*;

class Solution {
	private static char[][] digitGroups = {
		{},
		{}, 
		{'a', 'b', 'c'},
		{'d', 'e', 'f'},
		{'g', 'h', 'i'},
		{'j', 'k', 'l'},
		{'m', 'n', 'o'},
		{'p', 'q', 'r', 's'},
		{'t', 'u', 'v'},
		{'w', 'x', 'y', 'z'},
	};

	private void dfs(List<String> result, String digits, int index, StringBuilder path) {
			// 끝까지 탐색했으면 결과를 저장하고 리턴
			if (path.length() == digits.length()) {
				result.add(String.valueOf(path));
				return;
			}

			// 현재 자리 숫자에 해당하는 모든 문자열 탐색
			int num = Character.getNumericValue(digits.charAt(index));
			for (Character c : digitGroups[num]) {
				// 현재 자리 + 1, 지금까지 구성된 문자열 path 이용 재귀 DFS
				dfs(result, digits, index + 1, new StringBuilder(path).append(c));
			}
		}

	public List<String> letterCombinations(String digits) {
		// 결과 저장 리스트 선언
		List<String> result = new ArrayList<>();
		// 예외 처리
		if (digits.length() == 0) {
			return result;
		}

		// 현재 자리 0, 빈 문자열 이용 DFS 시작
		dfs(result, digits, 0, new StringBuilder());
		
		return result;
	}
}