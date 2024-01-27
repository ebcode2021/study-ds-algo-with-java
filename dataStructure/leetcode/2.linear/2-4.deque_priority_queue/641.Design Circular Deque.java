import java.util.*;

class MyCircularDeque {

	// 이중 연결 리스트로 사용할 클래스 선언
	static class DoublyLinkedList {
		DoublyLinkedList left;
		DoublyLinkedList right;

		int val;

		public DoublyLinkedList(int val) {
			this.val = val;
		}
	}

	int len; // 현재 큐의 크기
	int k; // 전체 큐의 크기
	DoublyLinkedList head;
	DoublyLinkedList tail;

	public MyCircularDeque(int k) {
		// 이중 연결 리스트 2개 생성
		head = new DoublyLinkedList(0);
		tail = new DoublyLinkedList(0);

		head.right = tail;
		tail.left = head;
		this.k = k;
		this.len = 0;
	}

	public boolean insertFront(int value) {
		if (isFull())
			return false;
		DoublyLinkedList node = new DoublyLinkedList(value);
		// 신규 노드는 head의 바로 오른쪽에 삽입
		node.right = head.right;
		node.left = head;
		head.right.left = node;
		head.right = node;
		len++;
		return true;
	}

	public boolean insertLast(int value) {
		if (isFull())
			return false;
		DoublyLinkedList node = new DoublyLinkedList(value);
		node.left = tail.left;
		node.right = tail;
		tail.left.right = node;
		tail.left = node;
		len++;
		return true;
	}

	public boolean deleteFront() {
		if (isEmpty())
			return false;
		head.right.right.left = head;
		head.right = head.right.right;
		len--;
		return true;
	}

	public boolean deleteLast() {
		if (isEmpty())
			return false;
		tail.left.left.right = tail;
		tail.left = tail.left.left;
		len--;
		return true;
	}

	public int getFront() {
		return (isEmpty() ? -1 : head.right.val);
	}

	public int getRear() {
		return (isEmpty() ? -1 : tail.left.val);
	}

	public boolean isEmpty() {
		return len == 0;
	}

	public boolean isFull() {
		return len == k;
	}
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */