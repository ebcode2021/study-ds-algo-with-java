class Solution {
	private static int bfs(TreeNode node, int depth) {
		int leftRoute = 0;
		int rightRoute = 0;

		if (node == null || node.left == null && node.right == null) {
			return depth;
		}

		if (node.left != null) {
			leftRoute = bfs(node.left, depth + 1);
		}

		if (node.right != null) {
			rightRoute = bfs(node.right, depth + 1);
		}

		return leftRoute > rightRoute ? leftRoute : rightRoute;
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return bfs(root, 0) + 1;
	}
}