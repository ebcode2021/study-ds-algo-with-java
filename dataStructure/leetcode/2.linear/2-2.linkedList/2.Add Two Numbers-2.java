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

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode root = node;

		int sum, carry = 0, remainder;

		while (l1 != null || l2 != null || carry != 0) {
			sum = 0;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			// 노드의 값으로 사용할 나머지 계산
			remainder = (sum + carry) % 10;
			// 10으로 나누었을 때 몫은 자릿수가 증가했다는 의미이므로 자리올림수로 사용
			carry = (sum + carry) / 10;
			// 나머지는 다음 노드의 값으로 지정
			node.next = new ListNode(remainder);
			// 계산할 노드를 다음으로 이동
			node = node.next;
		}
		// 첫 번째 노드는 임시 노드이므로 그다음부터 결과로 리턴
		return root.next;
	}
}