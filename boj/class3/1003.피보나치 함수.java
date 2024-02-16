import java.io.*;

class Main {
	private static int[][] storage = new int[41][2];

	private static void initStorage() {
		storage[0][0] = 1;
		storage[0][1] = 0;
		storage[1][0] = 0;
		storage[1][1] = 1;
	}

	private static int[] fibonnaci(int num) {
		if (storage[num][0] + storage[num][1] == 0) {
			storage[num][0] = fibonnaci(num - 1)[0] + fibonnaci(num - 2)[0];
			storage[num][1] = fibonnaci(num - 1)[1] + fibonnaci(num - 2)[1];
		}
		return storage[num];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		initStorage();

		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			
			fibonnaci(num);

			bw.write(storage[num][0] + " " + storage[num][1] + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}