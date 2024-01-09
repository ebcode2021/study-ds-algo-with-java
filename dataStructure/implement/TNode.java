package dataStructure.implement;

public class TNode {
	char	val;
	TNode	left;
	TNode	right;

	public TNode(char val) {
		this.val = val;
	}

	public TNode(char val, TNode left, TNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
