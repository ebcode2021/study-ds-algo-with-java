/**
 * Solve 1 : O(nlogn)
 * Wrong Cnt : 0
 * Result : Runtime(3ms, Beats 90.20%), Memory(44.86MB, Beats : 26.95%)
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] beforeArr = s.toCharArray();
        char[] afterArr = t.toCharArray();
        Arrays.sort(beforeArr);
        Arrays.sort(afterArr);

        for (int i = 0; i < s.length(); i++) {
            if (beforeArr[i] != afterArr[i]) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Solve 2 : O(n)
 * Wrong Cnt : 0
 * Result : Runtime(3ms, Beats 90.20%), Memory(44.75MB, Beats : 36.42%)
 */
class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabetArr = new int[26];

		for (int i = 0; i < s.length(); i++) {
			alphabetArr[s.charAt(i) - 'a']++;
			alphabetArr[t.charAt(i) - 'a']--;
		}

		for (int i = 0; i < 26; i++) {
			if (alphabetArr[i] != 0) {
				return false;
			}
		}
        return true;
    }
}

/**
 * Solve 3: O(nlogn)::Book
 * Wrong Cnt : 0
 * Result : Runtime(5ms, Beats 53.45%), Memory(43.19MB, Beats : 79.30%)
 */
class Solution3{
    public boolean isAnagram(String s, String t) {
        return sort(s) .equals(sort(t));
    }

	public String sort(String s) {
		// 문자열을문자배열로변환
		char[] chars = s.toCharArray(); 
		Arrays.sort(chars);
		return new String(chars);
	}
}