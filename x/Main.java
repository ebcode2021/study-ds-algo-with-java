import java.io.*;
import java.util.*;

class Main {

	private static boolean isOpenBrace(char c) {
		if (c == '(' || c == '[')
			return true;
		return false;
	}

	private static boolean isCloseBrace(char c) {
		if (c == ']' || c == ')')
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			char[] input = br.readLine().toCharArray();
			
			if (input.length == 1 && input[0] == '.') {
				break;
			}
			
			Deque<Character> stack = new ArrayDeque<>();
			int idx = 0;
			boolean flag = true;

			while (idx < input.length) {
				char current = input[idx];
				if (isOpenBrace(current) == true) {
					stack.push(current);
				} else if (isCloseBrace(current) == true) {
					if (stack.isEmpty()) {
						flag = false;
						break ;
					}
					char pop = stack.pop();
					if (!((pop == '(' && current == ')') || (pop == '[' && current == ']'))) {
						flag = false;
						break ;
					}
				}
				idx++;
			}

			if (!stack.isEmpty() || flag == false) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}
		}
	}
}
