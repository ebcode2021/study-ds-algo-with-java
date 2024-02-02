import java.io.*;
import java.util.*;

class test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int judgeCnt = Integer.parseInt(br.readLine());

		String[][] arr = new String[judgeCnt][2];

		for (int i = 0; i < judgeCnt; i++) {
			String[] input = br.readLine().split(" ");
			arr[i][0] = input[0];
			arr[i][1] = input[1];
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if (o1[0].equals(o2[0])) {
				return 0;
			} else {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});

		for (int i = 0; i < judgeCnt; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}

	}
}