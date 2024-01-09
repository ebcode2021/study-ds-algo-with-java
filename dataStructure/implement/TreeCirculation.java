package dataStructure.implement;

public class TreeCirculation {
	TNode root = new TNode('F',
	new TNode('B',
		new TNode('A'),
		new TNode('D', 
			new TNode('C'), new TNode('E'))
	),
	new TNode('G',
			null,
			new TNode('I',
				new TNode('H'), null))
	);
		
	// 전위 순회
	public void preorder(TNode node) {
		if (node == null)
			return;
		System.out.printf("%c ", node.val);
		preorder(node.left);
		preorder(node.right);
	}

		
	// 중위 순회
	public void inorder(TNode node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.printf("%c ", node.val);
		inorder(node.right);
	}

		
	// 전위 순회
	public void postorder(TNode node) {
		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.printf("%c ", node.val);
	}

	public static void main(String[] args) {
		TreeCirculation tree = new TreeCirculation();
		TNode root = tree.root;
		System.out.println("전위 순회");
		tree.preorder(root);
		System.out.println("\n중위 순회");
		tree.inorder(root);
		System.out.println("\n후위 순회");
		tree.postorder(root);
	}
}
