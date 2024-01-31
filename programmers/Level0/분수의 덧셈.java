class Solution {
    static int dividedValue(int numer, int denom) {   
        int len = numer < denom ? numer : denom;
         for (int i = len; len >= 2; len--) {
            if (denom % len == 0 && numer % len == 0) {
                return len;
            }
        }
        return 0;
    }
    // numer : 분자, denom : 분모
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {

        int denom = denom1 * denom2;
        int numer = numer1 * denom2 + numer2 * denom1;

        int value = dividedValue(denom, numer);
        while (value != 0) {
            denom /= value;
            numer /= value;
            value = dividedValue(denom, numer);
        }
        int[] res = {numer, denom};
        return res;
    }
}