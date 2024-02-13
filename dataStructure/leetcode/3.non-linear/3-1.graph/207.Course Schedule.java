import java.util.*;

class Solution {

	private static boolean dfs(Map<Integer, List<Integer>> finishToTakeMap, Integer finish, List<Integer> takes, List<Integer> taken) {
		// 완료해야 하는 노드가 처리해야 하는 노드에 이미 포함되어 있다면 그래프가 순환 구조이므로 false 리턴
		if (takes.contains(finish))
			return false;
		
		// 이미 처리한 노드라면 true 리턴
		if (taken.contains(finish))
			return true;
		
		// 완료해야 하는 코스에 값이 있다면
		if (finishToTakeMap.containsKey(finish)) {
			// 처리해야 하는 노드에 현재 완료해야 하는 노드 추가
			takes.add(finish);

			// 처리해야 하는 노드 순회
			for (Integer take : finishToTakeMap.get(finish)) {
				// 재귀 DFS, 탐색 결과가 false라면 false를 리턴
				if (!dfs(finishToTakeMap, take, takes, taken))
					return false;
			}
			// 탐색 후에는 처리했으므로 노드 제거
			takes.remove(finish);
			// 이미 처리한 노드 추가
			taken.add(finish);
		}
		return true;
	}
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> finishToTakeMap = new HashMap<>();

		for (int[] pre : prerequisites) {
			finishToTakeMap.putIfAbsent(pre[0], new LinkedList<>());
			finishToTakeMap.get(pre[0]).add(pre[1]);
		}

		// 처리해야 하는 노드를 저장하는 변수
		List<Integer> takes = new ArrayList<>();
		// 처리한 노드를 저장하는 변수
		List<Integer> taken = new ArrayList<>();

		// 완료해야 하는 노드 순회
		for (Integer finish : finishToTakeMap.keySet()) {
			// dfs 결과가 false라면 최종 결과도 false로 리턴
			if (!dfs(finishToTakeMap, finish, takes, taken))
				return false;
		}
		return true;
	}
}