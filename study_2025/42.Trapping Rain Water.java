class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // 왼쪽이 더 낮을 경우
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // 왼쪽 최대값 갱신
                } else {
                    waterTrapped += leftMax - height[left];
                }
                left++;
            } else {
                // 오른쪽이 더 낮을 경우
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // 오른쪽 최대값 갱신
                } else {
                    waterTrapped += rightMax - height[right];
                }
                right--;
            }
        }

        return waterTrapped;
    }
}