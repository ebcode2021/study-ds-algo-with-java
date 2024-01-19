import java.util.*;
import java.io.*;

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
	
		ListNode oddList = new ListNode(0);
		ListNode evenList = new ListNode(0);
	
		ListNode oddCurrent = oddList;
		ListNode evenCurrent = evenList;
	
		ListNode current = head;
		int pivot = 1;
	
		while (current != null) {
			if (pivot % 2 != 0) { // 홀수
				oddCurrent.next = current;
				oddCurrent = oddCurrent.next;
			} else { // 짝수
				evenCurrent.next = current;
				evenCurrent = evenCurrent.next;
			}
			current = current.next;
			pivot++;
		}
	
		// 짝수 리스트의 끝을 null로 설정
		evenCurrent.next = null;
	
		// 홀수 리스트와 짝수 리스트를 잇는 작업
		oddCurrent.next = evenList.next;
	
		// 조합된 리스트 반환
		return oddList.next;
	}
	
}