import java.io.*;
import java.util.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int mother = 1;
		int son = 1;
		for (int i = 0; i < K; i++) {
			mother *= (N - i);
			son *= (K - i);
		}
		
		System.out.println(mother / son);
	}
}