import java.util.*;

/* deque를 사용한 풀이(stack보다 2배 빠르다) */
class Solution {
	public boolean isPalindrome(ListNode head) {
		Deque<Integer> deque = new LinkedList<>();

		ListNode node = head;
		while (node != null) {
			deque.add(node.val);
			node = node.next;
		}

		while (!deque.isEmpty() && deque.size() > 1) {
			if (deque.pollFirst() != deque.pollLast()) {
				return false;
			}
		}
		return true;
	}
}