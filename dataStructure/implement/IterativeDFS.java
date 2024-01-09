package dataStructure.implement;

import java.util.*;

public class IterativeDFS {
	
	// 인접 리스트
	private Map<Integer, List<Integer>> graph;

	public List<Integer> iterativeDFS(int v) {
		// 결과 노드를 저장할 리스트 선언
		List<Integer> discovered = new ArrayList<>();
		// 스택 선언은 효율적인 ArrayDeque 자료형 사용
		Deque<Integer> stack = new ArrayDeque<>();
		// 현재 노드를 스택에 삽입
		stack.push(v);
		// 스택이 모두 비워질 때까지 반복
		while (!stack.isEmpty()) {
			// 스택에서 추출
			v = stack.pop();
			// 이미 방문한 노드가 아니라면 방문 노드에 추가하고 주변 노드를 모두 스택에 삽입
			if (!discovered.contains(v)) {
				discovered.add(v);
				// 현재 노드에서 연결된 모든 주변 노드를 스택에 삽입
				for (int w : graph.get(v)) {
					stack.push(w);
				}
			}
		}
		// 더 이상 탐색할 노드가 없으면 리턴
		return discovered;
	}
}
