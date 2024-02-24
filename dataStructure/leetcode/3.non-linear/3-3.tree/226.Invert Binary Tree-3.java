
// 3번 풀이 :: 재귀 구조 DFS 후위 순회
class Solution {

	public TreeNode invertTree(TreeNode root) {
		// 빈 노드가 아닐 때 처리
		if (root != null) {
			invertTree(root.left);
			invertTree(root.right);

			// 왼쪽/오른쪽 자식 노드 스왑
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}
}