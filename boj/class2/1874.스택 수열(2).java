import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		Deque<Integer> stack = new ArrayDeque<>();
		int lastValue = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num > lastValue) {
				for (int j = lastValue + 1; j <= num; j++) {
					stack.push(j);
					sb.append("+\n");
				}
				lastValue = num;
			} else {
				if (stack.peek() != num) {
					System.out.println("NO");
					return;
				}
			}
			stack.pop();
			sb.append("-\n");
		}
		System.out.print(sb);
		br.close();
	}
}