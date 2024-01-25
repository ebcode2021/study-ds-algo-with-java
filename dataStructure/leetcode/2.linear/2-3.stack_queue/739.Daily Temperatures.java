import java.util.*;

class Solution {
	public int[] dailyTemperatures(int[] temperatures) {
		int[] res = new int[temperatures.length];
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int last = stack.pop();
				res[last] = i - last;
			}
			stack.push(i);
		}
		return res;
	}
}