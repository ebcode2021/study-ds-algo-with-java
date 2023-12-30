package dataStructure.implement;

public class MyStack {
	MyNode last;

	public MyStack() {
		this.last = null;
	}

	public void push(int item) {
		// 입력값으로 신규 노드를 생성하며, 기존의 마지막 노드는 다음 노드가 된다.
		this.last = new MyNode(item, this.last);
	}

	public int pop() {
		// 마지막 노드의 값을 끄집어낸다.
		int item = this.last.item;
		// 마지막 노드를 한 칸 앞으로 이동한다.
		this.last = this.last.next;
		return item;
	}
}
