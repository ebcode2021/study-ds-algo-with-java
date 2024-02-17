import java.util.*;

class Solution {
	public int networkDelayTime(int[][] times, int n, int k) {
		Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
		
		for (int[] time : times) {
			graph.putIfAbsent(time[0], new HashMap<>());
			// 출발지에 (도착지, 소요 시간) 추가
			graph.get(time[0]).put(time[1], time[2]);
		}

		// 우선순위 큐 생성, 값이 (도착지, 소요 시간)으로 구성되므로
		// 정렬 기준은 도착지(key)와 소요 시간(value) 중 소요 시간을 기준으로 한다.
		Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
		// (도착지, 소요시간)을 큐에 삽입, 시작은 출발지 k, 소요시간은 출발지이므로 당연히 0
		pq.add(new AbstractMap.SimpleEntry<>(k, 0));

		// (도착지, 소요 시간) 최종 결과를 저장하는 변수 선언
		Map<Integer, Integer> dist = new HashMap<>();
		// 큐에 값이 남아 있다면 없어질 때까지 반복
		while (!pq.isEmpty()) {
			// 소요 시간이 가장 빠른 값 추출
			Map.Entry<Integer, Integer> cur = pq.poll();
			int u = cur.getKey();
			int dist_u = cur.getValue();

			// u 지점까지 소요 시간이 아직 계산되지 않았다면 처리 시작
			if (!dist.containsKey(u)) {
				// u 지점까지의 소요 시간(dist_u)을 결과 변수에 삽입
				dist.put(u, dist_u);
				if (graph.containsKey(u)) {
					// u 지점을 출발지로 한 모든 경로 순회
					for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
						int alt = dist_u + v.getValue();
						pq.add(new AbstractMap.SimpleEntry<>(v.getKey(), alt));
					}
				}
			}
		}
		if (dist.size() == n) {
			return Collections.max(dist.values());
		}
		return -1;
	}

}
