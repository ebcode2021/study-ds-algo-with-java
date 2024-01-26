import java.util.LinkedList;
import java.util.Queue;

class MyStack {

	private Queue<Integer> queue = new LinkedList<>();

	public MyStack() {}

	public void push(int x) {
		queue.add(x);
		for (int i = 1; i < queue.size(); i++) {
			queue.add(queue.remove());
		}
	}

	public int pop() {
		return queue.remove();
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		if (queue.isEmpty())
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.empty());
	}
}
