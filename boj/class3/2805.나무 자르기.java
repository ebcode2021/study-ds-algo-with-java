import java.io.*;
import java.util.*;

/**
 * 나무 M 미터가 주어짐
 * 절단기에 높이 H 지정(땅 기준)
 * M - H 길이의 토막을 갖고 감.
 * 나무의 수 : N, 나무의 길이 : M(20억)
 * 높이는 H(10억)
 * 숫자가 너무 커서 하나씩 증가시키면 안되고, binarySearch..?
 * 
 */
class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = input[0];
		int M = input[1];

		int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] trees = new int[N];

		int min = 0;
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			trees[i] = data[i];
			if (max < trees[i]) {
				max = trees[i];
			}
		}

		while (min < max) {
			int mid = (min + max) / 2;
			long sum = 0;

			for (int tree : trees) {
				if (tree - mid > 0) {
					sum += (tree - mid);
				}
			}

			if (sum < M) {
				max = mid;
			}  else {
				min = mid + 1;
			}
		}
		System.out.println(min - 1);
	}
}