import java.util.*;

class Solution {
	public static String removeDuplicateLetters(String s) {
		// 문자 개수를 계산해서 담아둘 변수 선언
		Map<Character, Integer> counter = new HashMap<>();
		// 이미 처리한 문자 여부를 확인하기 위한 변수 선언
		Map<Character, Boolean> seen = new HashMap<>();
		// 문제 풀이에 사용할 스택 선언
		Deque<Character> stack = new ArrayDeque<>();

		// 문자별 개수 계산
		for (char c : s.toCharArray()) {
			counter.put(c, counter.get(c) == null ? 1 : counter.get(c) + 1);
		}

		for (char c : s.toCharArray()) {
			// 현재 처리하는 문자는 카운터에서 -1 처리
			counter.put(c, counter.get(c) - 1);
			// 이미 처리한 문자는 건너뛰기
			if (seen.get(c) != null && seen.get(c) == true) {
				continue;
			}
			// 스택에 있는 문자가 현재 문자보다 더 뒤에 붙여야 할 문자라면 스택에서 제거하고 처리하지 않은 걸로 표시
			while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
				seen.put(stack.pop(), false);
			}
			// 현재 문자를 스택에 삽입
			stack.push(c);
			seen.put(c, true);
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pollLast());
		return sb.toString();
	}
}