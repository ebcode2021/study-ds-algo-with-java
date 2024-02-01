import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i < 10; i++) {
			bw.append(n + " * " + i + " = " + n * i + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}