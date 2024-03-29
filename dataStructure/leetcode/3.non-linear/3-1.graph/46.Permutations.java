import java.util.*;
import java.util.stream.Collectors;

class Solution {

	public void dfs(List<List<Integer>> results, List<Integer> prevElements, List<Integer> elements) {
		// leaf node에 도달하면 결과에 추가(복사분 생성하여 저장)
		if (elements.isEmpty()) {
			results.add(prevElements.stream().collect(Collectors.toList()));
		}

		// 전달 받은 엘리먼트를 모두 탐색
		for (Integer e : elements) {
			// 전달받은 엘리먼트에서 현재 엘리먼트를 제외하고 nextElements로 새롭게 구성
			List<Integer> nextElements = new ArrayList<>(elements);
			nextElements.remove(e);
			
			// prevElements는 기존 값에 현재 엘리먼트 추가
			prevElements.add(e);
			// 재귀 DFS
			dfs(results, prevElements, nextElements);

			// 돌아온 이후에는 prevElements에서 현재 엘리먼트 삭제
			prevElements.remove(e);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> lst = Arrays.stream(nums).boxed().collect(Collectors.toList());

		// DFS 시작
		dfs(results, new ArrayList<>(), lst);

		return results;
	}
}