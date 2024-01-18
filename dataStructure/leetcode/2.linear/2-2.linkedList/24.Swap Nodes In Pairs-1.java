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
		// ListNode의 길이가 2미만일 경우 그냥 리턴
		if (head == null || head.next == null)
			return head;
		
		ListNode current = head;
		while (current != null && current.next != null) {
			int tmp = current.next.val;
			current.next.val = current.val;
			current.val = tmp;
			current = current.next.next;
		} 
		return head;
	}
}