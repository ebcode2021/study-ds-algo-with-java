import java.util.*;

public class IterativeBFS {
	private Map<Integer, List<Integer>> graph;

	public List<Integer> iteraticeBFS(int start_v) {
		List<Integer> discovered = new ArrayList<>();

		discovered.add(start_v);

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start_v);

		while (!queue.isEmpty()) {
			int v = queue.poll();
			for (int w : graph.get(v)) {
				if (!discovered.contains(w)) {
					discovered.add(w);
					queue.add(w);
				}
			}
		}
		return discovered;
	}
}
