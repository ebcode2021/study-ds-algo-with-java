import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		while (cnt-- > 0) {
			int value = Integer.parseInt(br.readLine());
			if (value == 0) {
				if (pq.size() == 0) {
					bw.append(0 + "\n");
				} else {
					bw.append(pq.poll() + "\n");
				}
			} else {
				pq.add(value);
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}
}