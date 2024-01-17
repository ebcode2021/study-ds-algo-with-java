import java.util.*;

/* 내가 푼 풀이(List 사용) */
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
	public boolean isPalindrome(ListNode head) {
		List<Integer> nodeList = new ArrayList<>();

		while (head != null) {
			nodeList.add(head.val);
			head = head.next;
		}

		int nodeListSize = nodeList.size();
		for (int i = 0; i < nodeListSize / 2; i++) {
			if (nodeList.get(i) != nodeList.get(nodeListSize - 1 - i))
				return false;
		}
		return true;
	}
}