class Solution {
    // num : 숫자 개수, total : 숫자의 합
    // 0 부터 n까지의 합 : n(n + 1)/2
    public int[] solution(int num, int total) {
        int n = 0;

        while (true) {
            int sum = 0;
            for (int i = n; i < n + num; i++) {
                sum += i;
            }
            if (sum == total)
                break ;
            if (sum < total) {
                n += 1;
            } else {
                n -= 1;
            }
        }

        int[] answer = new int[num];
        for (int i = 0; i < num; i++) {
            answer[i] = n + i;
        }
        return answer;
    }
}