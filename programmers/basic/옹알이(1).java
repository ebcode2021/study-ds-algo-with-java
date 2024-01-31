import java.util.*;

class Solution {

	static List<String> babbleList = Arrays.asList("aya", "ye", "woo", "ma");

	static boolean make(String word) {
		int length = 0;

		if (word.contains("aya")) {
			length += 3;
		}
		if (word.contains("ye")) {
			length += 2;
		}
		if (word.contains("woo")) {
			length += 3;
		}
		if (word.contains("ma")) {
			length += 2;
		}

		if (word.length() == length) {
			return true;
		}
		return false;
	}

	public int solution(String[] babbling) {
		int answer = 0;

		List<String> babbleList = Arrays.asList("aya", "ye", "woo", "ma");

		for (String babble : babbling) {
			if (make(babble)) {
				answer += 1;
			}
		}
		return answer;
	}
}