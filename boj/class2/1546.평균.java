import java.io.*;
import java.util.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int[] scoreArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Arrays.sort(scoreArr);

		int max = scoreArr[num - 1];

		double[] scoreDoubleArr = new double[num];
		for (int i = 0; i < num; i++) {
			scoreDoubleArr[i] =((double)scoreArr[i] / max) * 100;
		}

		System.out.println(Arrays.stream(scoreDoubleArr).average().getAsDouble());
	}
}