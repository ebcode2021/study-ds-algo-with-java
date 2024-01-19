import java.io.*;
import java.util.*;

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

	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return head;

		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;

		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;

	}

}