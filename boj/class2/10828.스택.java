import java.io.*;

class Main {
	private static void push(int[] storage, int idx, int value) {
		storage[idx] = value;
	}

	
	private static void empty(int idx) {
		System.out.println(idx == 0 ? 1 : 0);
	} 

	private static void top(int[] storage, int idx) {
		if (idx == 0) {
			System.out.println(-1);
		} else {
			System.out.println(storage[idx - 1]);
		}
	}

	private static void size(int idx) {
		System.out.println(idx);
	}

	private static void pop(int[] storage, int idx) {
		if (idx == 0) {
			System.out.println(-1);
		} else {
			System.out.println(storage[idx - 1]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		int[] storage = new int[num];

		int idx = 0;
		for(int i = 0; i < num; i++) {
			String[] input = br.readLine().split(" ");

			if (input.length == 2) {
				push(storage, idx, Integer.parseInt(input[1]));
				idx++;
			} else {
				switch (input[0]) {
					case "top" :
						top(storage, idx);
						break;
					case "empty" :
						empty(idx);
						break;
					case "size" :
						size(idx);
						break ;
					case "pop" :
						pop(storage, idx);
						if (idx > 0) {
							idx--;
						}
						break ;
					default :
						System.out.println("여긴 들어오면 안됨");
				}
			}
		}
	}
}