public class Solution {
	public int trap(int[] height) {
		int volume = 0;
		int left = 0;
		int right = height.length - 1;
		int leftMax = height[left];
		int rightMax = height[right];

		while (left < right) {
			leftMax = Math.max(height[left], leftMax);
			rightMax = Math.max(height[right], rightMax);

			if (leftMax <= rightMax) {
				// 왼쪽 막대 최대 높이와의 차이를 더하고 왼쪽 포인터 이동
				volume += leftMax - height[left];
				left += 1;
			} else {
				// 오른쪽 막대 최대 높이와의 차이를 더하고 오른쪽 포인터 이동
				volume += rightMax - height[right];
				right -= 1;
			}
		}
		return volume;
    }
}
