import java.util.*;

class Solution {
	public int maxDepth(TreeNode root) {
		// 더 이상 존재하지 않는 노드라면 0 리턴
		if (root == null)
			return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		return Math.max(left, right) + 1;
	}
}