import java.util.*;

/**
 * Solve 1 : O(nlogn)
 * Wrong Cnt : 1
 * Result : Runtime(11ms, Beats 0.9%), Memory(45.13MB, Beats : 99.68%)
 */
class Solution {
    public int search(int[] nums, int target) {
        int[][] order = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            order[i][0] = nums[i]; 
            order[i][1] = i;
        }
        Arrays.sort(order, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < order.length; i++) {
            if (order[i][0] == target) {
                return order[i][1];
            }
        }
        return -1;
    }
}

/**
 * Solve 2 : O(logn)
 * Wrong Cnt : 0
 * Result : Runtime(0ms, Beats 100%), Memory(45.74MB, Beats : 60.27%)
 */
class Solution2 {
    public int search(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1; 
        
        while (left <= right) {
            int mid = left + (right - left) / 2;  
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;  
            } else {
                right = mid - 1; 
            }
        }
        
        return -1;
    }
}