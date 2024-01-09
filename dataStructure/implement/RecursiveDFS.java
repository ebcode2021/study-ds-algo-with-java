package dataStructure.implement;

import java.util.*;

public class RecursiveDFS {

	// 인접 리스트
	private Map<Integer, List<Integer>> graph;

	
	public List<Integer> recursiveDFS(int v, List<Integer> discovered) {
		// 현재 노드 저장(전위 순회)
		discovered.add(v);
		// 주변 노드 반복
		for (Integer w : graph.get(v)) {
			// 아직 처리되지 않은 노드라면 깊이 기반 탐색 진행
			if (!discovered.contains(w)) {
				discovered = recursiveDFS(w, discovered);
			}
		}
		return discovered;
	}
}
