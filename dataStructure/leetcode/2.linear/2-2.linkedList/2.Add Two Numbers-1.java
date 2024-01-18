import java.math.BigInteger;

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
	
	public ListNode reverseList(ListNode head) {
		ListNode prev = null, tmpHead = head;

		while (tmpHead != null) {
			ListNode next = tmpHead.next;
			tmpHead.next = prev;
			prev = tmpHead;
			tmpHead = next;
		}
		return prev;
	}

	public BigInteger toBigInt(ListNode node) {
		String val = "";

		while (node != null) {
			val += node.val;
			node = node.next;
		}
		return new BigInteger(val);
	}

	public ListNode toReversedLinkedList(BigInteger val) {
		ListNode prev = null, node = null;

		for (char c : String.valueOf(val).toCharArray()) {
			node = new ListNode(Character.getNumericValue(c));
			node.next = prev;
			prev = node;
		}
		return node;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode reverseList1 = reverseList(l1);
		ListNode reverseList2 = reverseList(l2);

		BigInteger result = toBigInt(reverseList1).add(toBigInt(reverseList2));
		return toReversedLinkedList(result);
	}
}