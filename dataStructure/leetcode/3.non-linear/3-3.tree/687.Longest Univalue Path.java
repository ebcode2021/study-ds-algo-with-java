import java.util.*;

class Solution {
	
	int longest = 0;

	public int dfs(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int left = dfs(node.left);
		int right = dfs(node.right);

		if (node.left != null && node.left.val == node.val) {
			left += 1;
		} else {
			left = 0;
		}

		if (node.right != null && node.right.val == node.val) {
			right += 1;
		} else {
			right = 0;
		}

		this.longest = Math.max(this.longest, left + right);
		return Math.max(left, right);

	}

	public int longestUnivaluePath(TreeNode root) {
		dfs(root);
		return this.longest;
	}
}