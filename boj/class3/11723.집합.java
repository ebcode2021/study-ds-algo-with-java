import java.io.*;
import java.util.*;

/**
 * 풀이 시작 시간 : 5시 10분
 * 풀이 완료 시간 : 5시 33분
 */

class Main {
	private static List<Integer> setArray() {
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= 20; i++) {
			list.add(i);
		}
		return list;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();

		int calculateCnt = Integer.parseInt(br.readLine());

		while (calculateCnt-- > 0) {
			String[] input = br.readLine().split(" ");
			String command = input[0];
			
			int num = 0;
			if (input.length != 1) {
				num = Integer.parseInt(input[1]);
			}

			if (command.equals("add")) {
				if (list.contains(num) == false) {
					list.add(num);
				};
			} else if (command.equals("remove")) {
				if (list.contains(num) == true) {
					list.remove(Integer.valueOf(num));
				}
			} else if (command.equals("check")) { 
				if (list.contains(num) == true) {
					sb.append("1" + "\n");
				} else {
					sb.append("0" + "\n");
				}
			} else if (command.equals("toggle")) {
				if (list.contains(num) == true) {
					list.remove(Integer.valueOf(num));
				} else {
					list.add(num);
				}
			} else if (command.equals("all")) {
				list.clear();
				list = setArray();
			} else { // commands.equals("empty")
				list.clear();
			}
		}
		br.close();
		System.out.print(sb);
	}
}