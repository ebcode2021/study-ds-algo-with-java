import java.io.*;

class Main {

	private static void push(int[] storages, int idx, int num) {
		storages[idx] = num;
	}

	private static void pop(int[] storages, int frontIdx, int backIdx) {
		System.out.println(storages[frontIdx]);
		storages[frontIdx] = 0;
	}

	private static int size(int frontIdx, int backIdx) {
		return backIdx - frontIdx;
	}

	private static void empty(int size) {
		if (size == 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	private static void front(int[] storages, int idx) {
		System.out.println(storages[idx]);
	}
	
	private static void back(int[] storages, int idx) {
		System.out.println(storages[idx - 1]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] storages = new int[10000];
		int frontIdx = 0;
		int backIdx = 0;

		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			String[] input = br.readLine().split(" ");

			if (input.length == 2) {
				push(storages, backIdx, Integer.parseInt(input[1]));
				backIdx++;
			} else {
				String command = input[0];
				int qSize = size(frontIdx, backIdx);
				switch(command) {
					case "pop" :
						if (qSize == 0) {
							System.out.println(-1);
						} else {
							pop(storages, frontIdx, backIdx);
							frontIdx++;
						}
						break ;
					case "size" :
						System.out.println(qSize);
						break ;
					case "front" :
						if (qSize == 0) {
							System.out.println(-1);
						} else {
							front(storages, frontIdx);
						}
						break ;
					case "back" :
						if (qSize == 0) {
							System.out.println(-1);
						} else {
							back(storages, backIdx);
						}
						break ;
					default :
						empty(qSize);
				}
			}
		}
	}
}