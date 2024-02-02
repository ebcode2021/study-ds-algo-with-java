import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int size = Integer.parseInt(input[0]);
		int lotate = Integer.parseInt(input[1]);

		Deque<Integer> deque = new ArrayDeque<>();
		List<Integer> array = new ArrayList<>();

		for (int i = 1; i <= size; i++) {
			deque.add(i);
		}

		while (!deque.isEmpty()) {
			for (int i = 0; i < lotate - 1; i++) {
				deque.add(deque.remove());
			}
			array.add(deque.remove());
		}

		System.out.print("<");
		for(int i = 0; i < size - 1; i++) {
			System.out.print(array.get(i) + ", ");
		}
		System.out.println(array.get(size - 1) + ">");
	}
}