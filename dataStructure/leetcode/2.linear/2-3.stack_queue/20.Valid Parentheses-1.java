import java.util.*;

/* 내 풀이 */
class Solution {
	public boolean isOpenBrace(char c) {
		if (c == '[' || c =='{' || c == '(')
			return true;
		return false;
	}

	public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		int len = s.length();

		for (int i = 0; i < len; i++) {
			char current = s.charAt(i);
			if (isOpenBrace(current) == true) {
				stack.push(current);
			} else {
				if (stack.isEmpty() == true)
					return false;
				char pop = stack.pop();
				if (pop == '[') {
					if (current != ']')
						return false;
				} else if (pop == '{') {
					if (current != '}')
						return false;
				} else {
					if (current != ')')
						return false;
				}
			}
		}
		if (stack.isEmpty() == false)
			return false;
		return true;
	}
}