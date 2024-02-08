import java.util.*;
import java.util.stream.*;

class Solution {

	public void dfs(List<List<Integer>> results, List<Integer> elements, int n, int start, int k) {
		// k번째 노드에 도달하면 결과에 추가
		if (k == 0) {
			// stream을 이용해 elements의 내용을 결과에 삽입
			results.add(elements.stream().collect(Collectors.toList()));
			return ;
		}

		for (int i = start; i <= n; i++) {
			// 전달받은 엘리먼트에 더해 현재 엘리먼트 추가
			elements.add(i);
			// 재귀 DFS
			dfs(results, elements, n, i + 1, k - 1);
			// 돌아온 이후에 현재 엘리먼트 삭제
			elements.removeLast();
		}
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> results = new ArrayList<>();

		dfs(results, new LinkedList<>(), n, 1, k);

		return results;
	}
}