class Solution {
	// solve : 문자열 직접 비교
	// feat : 클래스를 직접 비교하며, 정규식을 사용해 실행 속도 느림

	public boolean isPalindrome(String s) {
		String filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		String reversed = new StringBuilder(filtered).reverse().toString();
		return filtered.equals(reversed);
	}
}