class Solution {
	public class ListNode {
		int val;
		ListNode next;
		
		ListNode() {}
		ListNode(int val) { 
			this.val = val; 
		}
		ListNode(int val, ListNode next) { 
			this.val = val; 
			this.next = next; 
		}
	}

	public ListNode swapPairs(ListNode head) {
		ListNode node = new ListNode();
		ListNode root = node;
		node.next = head;

		while (node.next != null && node.next.next != null) {
			ListNode front = node.next;
			ListNode back = node.next.next;
			front.next = back.next;
			node.next = back;
			node.next.next = front;
			node = node.next.next;
		}
		return root.next;
	}
}