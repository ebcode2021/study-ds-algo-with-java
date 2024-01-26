import java.util.*;

class MyCircularQueue {

	int[] q;
	int front = 0, rear = -1, len = 0;

	public MyCircularQueue(int k) {
		// k 크기의 원형 큐로 사용할 배열
		this.q = new int[k];
	}

	public boolean enQueue(int value) {
		if (this.isFull()) 
			return false;
		// rear 포인터 한 칸 앞으로 이동, 최대 크기를 초과하면 나머지 위치로 이동
		this.rear = (this.rear + 1) % this.q.length;
		// rear 위치에 값 삽입
		this.q[rear] = value;
		// 현재 큐의 크기 계산
		this.len++;
		return true;
	}

	public boolean deQueue() {
		if (this.isEmpty())
			return false;
		// front 포인터 한 칸 앞으로 이동. 최대 크기를 초과하면 나머지 위치로 이동
		this.front = (this.front + 1) % this.q.length;
		// 현재 큐의 크기 계산
		this.len--;
		return true;
	}

	public int Front() {
		return (this.isEmpty()) ? -1 : this.q[this.front];
	}

	public int Rear() {
		return (this.isEmpty()) ? -1 : this.q[this.rear];
	}

	public boolean isEmpty() {
		return this.len == 0;
	}

	public boolean isFull() {
		return this.len == this.q.length;
	}
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */