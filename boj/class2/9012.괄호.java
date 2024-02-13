import java.io.*;
import java.util.*;

class Main {

	private static boolean isVPS(char[] inputs) {
		Deque<Integer> stack = new ArrayDeque<>();

		for (char input : inputs) {
			if (input == '(') {
				stack.push(0);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty() ? true : false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			char[] inputs = br.readLine().toCharArray();
			if (isVPS(inputs) == true) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
