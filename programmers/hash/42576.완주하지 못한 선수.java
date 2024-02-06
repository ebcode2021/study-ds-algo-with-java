import java.util.*;

class Solution {
	public String solution(String[] participant, String[] completion) {
		Map<String, Integer> m = new HashMap<>();

		// 참여 선수 이름, 동명이인인 경우 +1 해시맵 삽입
		for (String p : participant) {
			m.put(p, m.getOrDefault(p, 0) + 1);
		}

		for (String c : completion) {
			int left = m.get(c);
			if (left == 1) {
				m.remove(c);
			} else {
				m.put(c, left - 1);
			}
		}
		return m.entrySet().iterator().next().getKey();
	}
}