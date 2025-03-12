/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

package study_2025;

class Solution {
	/**
	 * Try 1  : Bubble Sort
	 * Result : Time Limit Exceeded
	 */
	public static ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode frontNode = head;
		ListNode backNode = head.next; 

		while (frontNode.next != null) {
			while (backNode != null) {
				if (frontNode.val > backNode.val) {
					int tmp = frontNode.val;
					frontNode.val = backNode.val;
					backNode.val = tmp;
				}
				backNode = backNode.next;
			}
			frontNode = frontNode.next;
			backNode = frontNode.next;
		}
		return head;
	}

	/**
	 * Try 2  : Merge Sort
	 * Result : 10ms
	 * Improve : Time Complexity(n^2 -> nlogn) + Early Return
	 * 코드 아쉬운 점 : 중간 지점을 찾을때 O(n) -> O(n/2), 
	 */
	public static ListNode sortList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode savePoint = head;
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}

		head = savePoint;
		int middle = len / 2;
		ListNode prev = head;
		ListNode back = head;
		for (int i = 0; i < middle; i++) {
			prev = back;
			back = back.next;
		}
		prev.next = null;
		
		ListNode left = sortList2(head);
		ListNode right = sortList2(back);

		return merge(left, right);
	}

	public static ListNode merge(ListNode left, ListNode right) {
		ListNode mergeHead = new ListNode();
		ListNode mergeTail = mergeHead;

		while (left != null && right != null) {
			if (left.val < right.val) {
				mergeTail.next = left;
				left = left.next;
			} else {
				mergeTail.next = right;
				right = right.next;
			}
			mergeTail = mergeTail.next; 
		}
		mergeTail.next = (left != null) ? left : right;

		return mergeHead.next;
	}

	public static void main(String[] args) {
		// Example 1
		ListNode listNode = new ListNode(4);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(1);
		listNode.next.next.next = new ListNode(3);

		System.out.println(listNode.toString());
		sortList(listNode);
		System.out.println(listNode.toString());

		// Example 2
		ListNode listNode2 = new ListNode(-1);
		listNode2.next = new ListNode(5);
		listNode2.next.next = new ListNode(3);
		listNode2.next.next.next = new ListNode(4);
		listNode2.next.next.next.next = new ListNode(0);
		System.out.println(listNode2.toString());
		sortList(listNode2);
		System.out.println(listNode2.toString());

		// Example 3
		ListNode listNode3 = new ListNode();
		System.out.println(listNode3.toString());
		sortList(listNode3);
		System.out.println(listNode3.toString());
	}

}
