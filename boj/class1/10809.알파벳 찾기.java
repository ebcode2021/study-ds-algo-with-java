import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] input = br.readLine().toCharArray();
		
		int[] arr = new int[26];
		Arrays.fill(arr, -1);

		for (int i = 0; i < input.length; i++) {
			int location = input[i] - 'a';
			
			if (arr[location] == -1) {{
				arr[location] = i;
			}}
		}
		
		for (int a : arr) {
			bw.write(a + " ");
		}

		bw.flush();
		bw.close();
	}
}