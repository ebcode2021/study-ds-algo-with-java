import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			TreeMap<Integer, Integer> queue = new TreeMap<>();
			int cnt = Integer.parseInt(br.readLine());

			while (cnt-- > 0) {
				st = new StringTokenizer(br.readLine());
				char operation = st.nextToken().charAt(0);
				int value = Integer.parseInt(st.nextToken());

				if (operation == 'I') {
					queue.put(value, queue.getOrDefault(value, 0) + 1);
				} else {
					if (queue.size() == 0) {
						continue;
					}
					int num = value == 1 ? queue.lastKey() : queue.firstKey();
					if (queue.put(num, queue.get(num) - 1) == 1) {
						queue.remove(num);
					}
				}
			}
			System.out.println(queue.size() == 0 ? "EMPTY" : queue.lastKey() + " " + queue.firstKey());
		}
		br.close();
	}
}