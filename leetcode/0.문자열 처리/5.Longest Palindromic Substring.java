class Solution {
	public String longestPalindrome(String s) {
		int compareLen = 2;
		int middleLen = s.length() / 2;
		int stringLen = s.length();
		
		String result = (stringLen > 1 ? String.valueOf(s.charAt(0)) : "");
		char[] charArr = s.toCharArray();

		while (compareLen <= stringLen)
		{
			for (int i = 0; i + compareLen <= stringLen ; i++) {
				int startIdx = i;
				while (startIdx <= middleLen) {
					if (charArr[startIdx] != charArr[stringLen - startIdx - 1]) {
						break ;
					}
					else {
						result = s.substring(startIdx, startIdx + compareLen);
					}
					startIdx++;
				}
			}
			compareLen++;
		}
		return result;
	}
}