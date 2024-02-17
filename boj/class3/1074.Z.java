import java.io.*;
import java.util.*;

class Main {
	private static int count = 0;

	private static void find(int size, int row, int col) {
		if (size == 1) {
			return ;
		}
		
		int mid = size / 2;
		int quarter = size * size / 4;
		
		if (row < mid && col < mid) { 
			find(mid, row, col);
		} else if (row < mid && col >= mid) { 
			count += quarter;
			find(mid, row, col - mid);
		} else if (row >= mid && col < mid) {
			count += quarter * 2;
			find(mid, row - mid, col);
		} else {
			count += quarter * 3;
			find(mid, row - mid, col - mid);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int N = input[0];
		int row = input[1];
		int col = input[2];
		int size = (int)Math.pow(2, N);

		find(size, row, col);

		System.out.println(count);
	}
}