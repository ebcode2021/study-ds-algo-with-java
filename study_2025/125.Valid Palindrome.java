/**
 * Solve 1 : O(n)
 * Wrong Cnt : 2
 * Result : Runtime(14ms, Beats 34.10%), Memory(44.94MB, Beats : 35.75%)
 */
class Solution {
    public boolean isPalindrome(String s) {
        char[] charArr = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase().toCharArray();
        int len = charArr.length;
        int mid = len / 2;

        for (int i = 0; i < mid; i++) {
            if (charArr[i] != charArr[len - i - 1]) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Solve 2 : O(n)
 * Wrong Cnt : 2
 * Result : Runtime(15ms, Beats 22.79%), Memory(44.69MB, Beats : 46.94%)
 */
class Solution2 {
    public boolean isPalindrome(String s) {
        char[] charArr = s.replaceAll("[^0-9a-zA-Z]", "").toCharArray();
        int len = charArr.length;
        int mid = len / 2;

        for (int i = 0; i < mid; i++) {
            if (Character.toLowerCase(charArr[i]) != Character.toLowerCase(charArr[len - i - 1])) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Solve 3 : O(n)
 * Wrong Cnt : 0
 * Result : Runtime(2ms, Beats 99.10%), Memory(42.60MB, Beats : 98.00%)
 */
class Solution3 {
    public boolean isPalindrome(String s) {
        int start = 0;
		int end = s.length() - 1;

		while (start < end) {
            if(!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
				end--;
			} else {
				if (Character.toLowerCase(s.charAt(start)) != Character. toLowerCase (s.charAt (end))) {
					return false;
				}
				start++;
				end--;
			}
		}
		return true;
    }
}