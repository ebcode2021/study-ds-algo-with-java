import java.util.*;

public class RecursiveDFS {

	private Map<Integer, List<Integer>> graph;

	public List<Integer> recursiveDFS(int v, List<Integer> discovered) {
		discovered.add(v);

		for (Integer w : graph.get(v)) {
			if (!discovered.contains(w)) {
				discovered = recursiveDFS(w, discovered);
			}
		}
		return discovered;
	}
}