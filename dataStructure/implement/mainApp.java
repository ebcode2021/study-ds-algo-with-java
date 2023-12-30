package dataStructure.implement;

public class mainApp {
	public static void main(String[] args) {

		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		while (stack.last != null) {
			System.out.println(stack.pop());
		}
	}
}
