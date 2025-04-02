/**
 * Solve 1 : O(n)
 * Wrong Cnt : 0
 * Result : Runtime(0ms, Beats 100%), Memory(49.24MB, Beats : 44.38%)
 */
class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        int mid = len / 2;
        char tmp;

        for (int i = 0; i < mid; i++) {
            tmp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = tmp;
        }
    }
}

/**
 * Solve 2 : O(n)
 * Wrong Cnt : 0
 * Result : Runtime(0ms, Beats 100%), Memory(49.18MB, Beats : 52.91%) // 실행시킬 때마다 변동 있음(Runtime : 0~1, Memory : 46~49)
 */
class Solution2 {
	public void reverseString(char[] s) {
		int start = 0;
		int mid = s.length / 2;
		int end = s.length - 1;
		char tmp;

		while (start < mid) {
			tmp = s[start];
			s[start] = s[end - start];
			s[end - start] = tmp;

			start++;
		}
	}
}

/**
 * Solve 3 : O(n) :: 풀이
 * Wrong Cnt : 0
 * Result : Runtime(0ms, Beats 100%), Memory(45.83MB, Beats : 82.02%) // 실행시킬 때마다 변동 있음(Runtime : 0~1, Memory : 46~49)
 */
class Solution3 {
    public void reverseString(char[] s) {
        int start = 0;
		int end = s.length - 1;

		while (start < end) {
			char tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;

			start++;
            end--;
		}
    }
}