
// 2번 풀이 :: 재귀 구조 DFS
class Solution {

	public TreeNode invertTree(TreeNode root) {
		// 빈 노드가 아닐 때 처리
		if (root != null) {
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;

			invertTree(root.left); // 왼쪽 자식 DFS
			invertTree(root.right); // 오른쪽 자식 DFS
		}
		return root;
	}
}