import java.io.*;
import java.util.*;

/**
 * 
 * [Rule]
 * 1. 잘못된 수 -> 0을 외침 -> 가장 최근에 쓴 수를 지운다.
 * 2. 모든 수를 받아 적은 후, 그 수의 합?
 * 3. 최종 합은 int의 max값보다 작거나 같다.
 *  ex) maxInt -> maxInt -> 0 -> 1 ?
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> stack = new ArrayDeque<>();

		// 입력 횟수
		int numCnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < numCnt; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				stack.pop();
			} else {
				stack.push(num);
			}
		}

		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		System.out.println(result);
	}
}