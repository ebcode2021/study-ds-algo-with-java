import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] whitePaper = new int[100][100];
	
		int count = Integer.parseInt(br.readLine());

		int area = 0;
		while (count-- > 0) {
			int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int x = data[0];
			int y = data[1];
			
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if (whitePaper[i][j] == 0) {
						whitePaper[i][j] = 1;
						area++;
					}
				}
			}
		}
		
		System.out.println(area);
	}
}