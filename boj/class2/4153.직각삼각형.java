import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int[] triangleArr = new int[3];

			triangleArr = Arrays.stream(br.readLine().split(" "))
								.mapToInt(Integer::parseInt)
								.sorted()
								.toArray();

			// 모든 요소가 0이라면 프로그램 종료
			if (Arrays.stream(triangleArr).sum() == 0) {
				break;
			}

			// 직각 삼각형이라면
			if (Math.pow(triangleArr[2], 2) == Math.pow(triangleArr[0], 2) + Math.pow(triangleArr[1], 2)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}
}