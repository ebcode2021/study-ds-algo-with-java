package dataStructure.implement;

import java.util.*;

public class IterativeBFS {

	// 인접 리스트
	private Map<Integer, List<Integer>> graph;

	public List<Integer> iterativeBFS(int start_v) {
		// 결과 노드를 저장할 리스트 선언
		List<Integer> discovered = new ArrayList<>();
		// 시작 노드 삽입
		discovered.add(start_v);
		// 큐는 인터페이스. 자료형 선언은 LinkedList 사용
		Queue<Integer> queue = new LinkedList<>();
		// 시작 노드 삽입
		queue.add(start_v);

		// 큐가 모두 비워질 때까지 반복
		while (!queue.isEmpty()) {
			// 큐에서 추출
			int v = queue.poll();
			// 현재 노드에서 연결된 모든 주변 노드를 큐에 삽입
			for (int w : graph.get(v)) {
				// 이미 방문한 노드가 아니라면 방문 노드에 추가하고 주변 노드를 모두 큐에 삽입
				if (!discovered.contains(w)) {
					discovered.add(w);
					queue.add(w);
				}
			}
		}
		// 더 이상 탐색할 노드가 없으면 리턴
		return discovered;
	}
}
