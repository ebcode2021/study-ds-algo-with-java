import java.io.*;
import java.util.*;

class Main {
	static int dot;
	static int[][] arr;
	static boolean[] visited;

	public static void dfs(int start) {
		if (visited[start] == true) {
			return ;
		}

		visited[start] = true;
		
		for (int i = 1; i <= dot; i++) {
			if (visited[i] == false && arr[start][i] == 1) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		dot = input[0];
		int line = input[1];

		arr = new int[dot + 1][dot + 1];
		visited = new boolean[dot + 1];


		while (line-- > 0) {
			int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			arr[data[0]][data[1]] = 1;
			arr[data[1]][data[0]] = 1;
		}

		int count = 0;
		for (int i = 1; i < dot + 1; i++) {
			if (visited[i] == false) {
				dfs(i);
				count++;
			}
		}

		System.out.println(count);
		br.close();
	}
}