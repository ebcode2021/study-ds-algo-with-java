class Solution {
    static int dividedValue(int numer, int denom) {   
        int len = numer < denom ? numer : denom;
         for (int i = len; i >= 2; i--) {
            if (denom % i == 0 && numer % i == 0) {
                return i;
            }
        }
        return 0;
    }
    // numer : 분자, denom : 분모
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {

        int denom = denom1 * denom2;
        int numer = numer1 * denom2 + numer2 * denom1;

        int value = dividedValue(denom, numer);
		
        if (value != 0) {
            denom /= value;
            numer /= value;
        }
        int[] res = {numer, denom};
        return res;
    }
}