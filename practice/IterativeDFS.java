import java.util.*;

public class IterativeDFS {
	
	private Map<Integer, List<Integer>> graph;

	public List<Integer> iterativeDFS(int v) {
		List<Integer> discovered = new ArrayList<>();
		Deque<Integer> stack = new ArrayDeque<>();

		stack.push(v);

		while (!stack.isEmpty()) {
			v = stack.pop();
			if (!discovered.contains(v)) {
				discovered.add(v);
				for (int w : graph.get(v)) {
					stack.push(v);
				}
			}
		}
		return discovered;
	}
}
