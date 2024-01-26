import java.util.*;

/* 스택으로 큐 구현하기 */
/* 내 풀이 */

class MyQueue {
	Deque<Integer> stack = new ArrayDeque<>();
	Deque<Integer> storage = new ArrayDeque<>();

	public MyQueue() {}

	public void push(int x) {
        while (!stack.isEmpty()) {
            storage.push(stack.pop());
        }
        stack.push(x);
        while (!storage.isEmpty()) {
            stack.push(storage.pop());
        }
	}

	public int pop() {
		return stack.pop();
	}

	public int peek() {
		return stack.getFirst().intValue();
	}

	public boolean empty() {
		return stack.isEmpty();
	}
}
