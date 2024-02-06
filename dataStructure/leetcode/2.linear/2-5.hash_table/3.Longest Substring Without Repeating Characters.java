import java.util.*;

class Solution {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> used = new HashMap<>();

		int maxLength = 0, left = 0, right = 0;

		for (char c : s.toCharArray()) {
			// 이미 등장했던 문자고, 슬라이딩 윈도우의 안쪽에 있다면 left 위치 업데이트
			if (used.containsKey(c) && left <= used.get(c)) {
				left = used.get(c) + 1;
			} else { // 최대 부분 문자열 길이 업데이트
				maxLength = Math.max(maxLength, right - left + 1);
			}
			// 현재 문자의 위치 삽입
			used.put(c, right); 
			right++;
		}
		return maxLength;
	}
}