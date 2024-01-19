import java.util.*;

class Solution {
	public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		// 유효성 검증을 위한 매핑 테이블
		Map<Character, Character> table = new HashMap<>() {{
			put(')', '(');
			put('}', '{');
			put(']', '[');
		}};

		for (int i = 0; i < s.length(); i++){
			if (!table.containsKey(s.charAt(i))) {
				stack.push(s.charAt(i));
			} else if (stack.isEmpty() || table.get(s.charAt(i)) != stack.pop()) {
				return false;
			}
		}
		return stack.size() == 0;
	}
}