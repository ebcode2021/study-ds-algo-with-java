import java.util.*;

/* stack을 사용한 풀이 */
class Solution {
	public boolean isPalindrome(ListNode head) {
		Deque<Integer> stack = new ArrayDeque<>();

		ListNode node = head;
		while (node != null) {
			stack.push(node.val);
			node = node.next;
		}

		while (head != null) {
			if (head.val != stack.pop()) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
}