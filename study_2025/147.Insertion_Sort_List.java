package study_2025;

/**
 * Solve 1 : O(n^2)
 * Try : 3
 * TestCase : Time Exceeded (Inf Loop)
 * Result : Runtime(20ms, 25.64%), Memory(44.92MB, 12.75%)
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        // 1. 미정렬 조건
        if (head == null || head.next == null) {
            return head;
        }
        // 2. ListNode 생성
        ListNode node = new ListNode(0);
        ListNode current = head;

        // 3. O(n^2)
        while (current != null) {
            ListNode prev = node;
            ListNode next = current.next;

            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }
            current.next = prev.next;
            prev.next = current;
            current = next;
        }
        
        return node.next;
    }
}

/**
 * Solve 2 : O(n^2)
 * Try : 5
 * TestCase : ...
 * Result : Runtime(6ms, 65.77%), Memory(44.47MB, 71.14%)
 */
class Solution2 {
    public ListNode insertionSortList(ListNode head) {
        // 1. 미정렬 조건
        if (head == null || head.next == null) {
            return head;
        }
        // 2. ListNode 생성
        ListNode node = new ListNode(head.val, head);
		ListNode prev = node;
        ListNode current = head;

        // 3. O(n^2)
        while (current != null) {
            if (prev.val <= current.val) {
				prev = current;
				current = current.next;
				continue;
			}
			ListNode point = node; // 반복 방지
			while (point.next.val <= current.val) {
				point = point.next;
			}
			ListNode tmp = current.next;
			current.next = point.next;
			point.next = current;
			prev.next = tmp;
			current = tmp;
        }
        return node.next;
    }
}