class Solution {
    public void reverseString(char[] s) {
        int len = s.length; 
        int compareCnt = len / 2;
        char tmp;

        for (int i = 0; i < compareCnt ; i++) {
            tmp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = tmp;
        }
    }
}