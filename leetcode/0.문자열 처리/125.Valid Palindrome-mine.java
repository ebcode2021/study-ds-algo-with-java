class Solution {
    public boolean isValid(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
            return true;
        return false;
    }

    public boolean isPalindrome(String s) {
        String lowerInput = s.toLowerCase();
        int len = lowerInput.length();
        int frontPos = 0;
        int backPos = len - 1;

        while (frontPos <= backPos) {
            char frontChar = lowerInput.charAt(frontPos);
            char backChar = lowerInput.charAt(backPos);
            if (isValid(frontChar) == false) {
                frontPos++;
                continue;
            } else if (isValid(backChar) == false) {
                backPos--;
                continue;
            }
            if (frontChar != backChar)
                return false;
            frontPos++;
            backPos--;
        }
        return true;
    }
}