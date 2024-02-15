import java.io.*;

class Main {
	private static void push(int[] storages, int idx, int value) {
		storages[idx] = value;
	}

	private static int size(int front, int back) {
		return back - front - 1;
	}

	private static void front(int[] storages, int idx) {
		System.out.println(storages[idx + 1]);
	}

	private static void back(int[] storages, int idx) {
		System.out.println(storages[idx - 1]);
	}

	private static void frontPop(int[] storages, int idx) {
		front(storages, idx);
		storages[idx] = 0;
	}

	private static void backPop(int[] storages, int idx) {
		back(storages, idx);
		storages[idx] = 0;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] storages = new int[20000];
		
		int commandCnt = Integer.parseInt(br.readLine());
		
		int frontIdx = 10000;
		int backIdx = 10001;
		for (int i = 0; i < commandCnt; i++) {
			String[] input = br.readLine().split(" ");
			String command = input[0];
			if (input.length == 2) {
				int value = Integer.parseInt(input[1]);
				if (command.equals("push_front")) {
					push(storages, frontIdx, value);
					frontIdx--;
				} else {
					push(storages, backIdx, value);
					backIdx++;
				}
			} else {
				int cnt = size(frontIdx, backIdx);
				if (command.equals("size")) {
					System.out.println(cnt);
				} else if (command.equals("empty")) {
					System.out.println(cnt > 0 ? 0 : 1);
				} else {
					if (cnt == 0) {
						System.out.println(-1);
						continue;
					}

					if (command.equals("front")) {
						front(storages, frontIdx);
					} else if  (command.equals("back")) {
						back(storages, backIdx);
					} else if (command.equals("pop_front")) {
						frontPop(storages, frontIdx);
						frontIdx++;
					} else {
						backPop(storages, backIdx);
						backIdx--;
					}
				}
			}
		}
	}
}