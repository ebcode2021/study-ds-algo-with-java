class Solution {    
    public int solution(int[] common) {
        int lastIdx = common.length - 1;
        // case1 : 등비가 1인 경우
        if (common[0] == common[1]) {
            return common[0];
        }
        // case 2 : 등차수열인 경우
        if (common[2] - common[1] == common[1] - common[0]) {
            return common[lastIdx] + (common[2] - common[1]);
        } else {
            return common[lastIdx] * (common[1] / common[0]);
        }
    }
}