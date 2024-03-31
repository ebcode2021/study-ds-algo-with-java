import java.io.*;
import java.util.*;

class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void printDeque(Deque<Integer> deque, boolean reversed) {

		sb.append("[");

		if (deque.size() > 0) {
			if (reversed == true) {
				sb.append(deque.pollLast());
				while (!deque.isEmpty()) {
					sb.append("," + deque.pollLast());
				}
			} else {
				sb.append(deque.pollFirst());
				while (!deque.isEmpty()) {
					sb.append("," + deque.pollFirst());
				}
			}
		}

		sb.append("]" + "\n");
	}

	public static void calculate(char[] commands, Deque<Integer> deque) {

		boolean reverseFlag = false;

		for (char command : commands) {
			if (command == 'R') {
				reverseFlag = !reverseFlag;
				continue;
			} 

			if (deque.isEmpty()) {
				sb.append("error" + "\n");
				return ;
			}

			if (reverseFlag == true) {
				deque.pollLast();
			} else {
				deque.pollFirst();
			}
		}
		
		printDeque(deque, reverseFlag);

	}

	public static void main(String[] args) throws IOException { //5430
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			char[] commands = br.readLine().toCharArray();
			int cnt = Integer.parseInt(br.readLine());
			Deque<Integer> deque = new LinkedList<>();

			st = new StringTokenizer(br.readLine(), "[],");
			for (int j = 0; j < cnt; j++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			calculate(commands, deque);
		}

		System.out.print(sb);
		br.close();
	}
}