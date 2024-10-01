import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());

		int[] ageArr = new int[N];
		String[] nameArr = new String[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ageArr[i] = Integer.parseInt(st.nextToken());
			nameArr[i] = st.nextToken();
		}

		int currentAge = 1;
		int count = 0;
		while (currentAge <= 200 && count < N) {
			for (int i = 0; i < N; i++) {
				if (ageArr[i] == currentAge) {
					bw.write(ageArr[i] + " " + nameArr[i] + "\n");
					count++;
				}
			}
			currentAge++;
		}

		bw.flush();
		bw.close();
		br.close();
	}
}