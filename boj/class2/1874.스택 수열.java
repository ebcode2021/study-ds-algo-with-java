import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] sequences = new int[n];
		for (int i = 0; i < n; i++) {
			sequences[i] = i + 1;
		}

		int[] input = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		Deque<Integer> stack = new ArrayDeque<>();
		Deque<Integer> results = new ArrayDeque<>();
		Deque<Character> operators = new ArrayDeque<>();

		int inputIdx = 0;
		int sequenceIdx = 0;

		while (inputIdx < n) {
			
			if (stack.isEmpty()) {
				stack.push(sequences[sequenceIdx]);
				operators.add('+');
				sequenceIdx++;
				continue;
			}

			if (stack.peek() == input[inputIdx]) {
				results.push(stack.pop());
				inputIdx++;
				operators.add('-');
			} else {
				if (sequenceIdx >= n) {
					break ;
				}
				stack.push(sequences[sequenceIdx]);
				sequenceIdx++;
				operators.add('+');
			}
		}

		if (results.size() != n) {
			System.out.println("NO");
		} else {
			while (!operators.isEmpty()) {
				System.out.println(operators.pop());
			}
		}
	}
}