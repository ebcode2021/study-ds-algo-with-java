import java.util.*;

class Solution {
	
	public void dfs(List<List<Integer>> results, int[] candidates, int target, int index, Deque<Integer> path) {

		if (target < 0) {
			return ;
		}
		if (target == 0) {
			results.add(new ArrayList<>(path));
			return ;
		}

		for (int i = index; i < candidates.length; i++) {
			path.add(candidates[i]);
			dfs(results, candidates, target - candidates[i], i, path);
			path.removeLast();
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<>();

		dfs(results, candidates, target, 0, new ArrayDeque<>());

		return results;
	}
}