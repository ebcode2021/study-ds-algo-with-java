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
		if (head != null && head.next != null) {
			ListNode node = head.next;
			head.next = swapPairs(node.next.next);
			node.next = head;
			return node;
		}
		return head;
	}
}