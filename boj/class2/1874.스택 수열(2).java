import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		Deque<Integer> stack = new ArrayDeque<>();
		int lastValue = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num > lastValue) {
				for (int j = lastValue + 1; j <= num; j++) {
					stack.push(j);
					bw.write("+\n");
				}
				lastValue = num;
			} else {
				if (stack.peek() != num) {
					bw.write("NO");
					break;
				}
			}
			stack.pop();
			bw.write("-\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}