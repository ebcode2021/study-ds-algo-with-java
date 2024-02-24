import java.util.*;

import javax.swing.tree.TreeNode;

// 5번 풀이 :: 반복 구조 BFS
class Solution {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		// 반복 DFS 처리를 위한 스택 선언
		Deque<TreeNode> queue = new LinkedList<>();
		// 큐에 루트부터 삽입
		queue.offer(root);

		// 큐이 모두 비워질 때까지 반복
		while (!queue.isEmpty()) {
			// 큐에서 노드 추출
			TreeNode node = queue.pop();
			// 왼쪽/오른쪽 자식 노드 스왑
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;

			// 왼쪽 자식 노드가 널이 아니면 큐 삽입
			if (node.left != null) {
				queue.offer(node.left);
			}
			// 오른쪽 자식 노드가 널이 아니면 큐 삽입
			if (node.right != null) {
				queue.offer(node.right);
			}
		}

		return root;
	}
}