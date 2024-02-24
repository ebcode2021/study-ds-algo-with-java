// 1번 풀이 :: 신규 노드 생성 재귀 구조 DFS

class Solution {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}

		// 현재 노드 값을 복사한 신규 노드 생성
		TreeNode newNode = new TreeNode(root.val);
		// 왼쪽 자식 노드는 오른쪽으로 재귀 DFS 진행
		newNode.left = invertTree(root.right);
		// 오른쪽 자식 노드는 왼쪽으로 재귀 DFS 진행
		newNode.right = invertTree(root.left);
		// 진행된 신규 노드 리턴
		return newNode;
	}
}