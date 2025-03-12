package study_2025;

public class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }

	@Override
	public String toString() {
		if (this.val == 0 && this.next == null) {
			return "[]";
		}
		String res = "[";
		ListNode head = this;

		while (head != null) {
			res += head.val;
			head = head.next;
			res += head != null ? "," : "]";
		}
		return res;
	}
}
