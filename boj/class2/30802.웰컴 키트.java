import java.io.*;
import java.util.*;

/**
 * 웰컴 키트 : 티셔츠 한 장 + 펜 한 자루
 * 티셔츠 -> S ~ XXXL 6 사이즈. 같은 사이즈 T장의 묶음으로 주문 가능
 * 펜 -> 1종류. P자루 묶음 or 1
 * 티셔츠를 T장씩 최소 몇 묶음 주문해야 하는지,
 * 펜은 P자루씩 최대 몇 묶음 주문 할 수 있고, 그 때 펜을 한 자루씩 몇 개 주문하는지
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int num = Integer.parseInt(br.readLine());
		int[] tArr = new int[6];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 6; i++) {
			tArr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		int tOrder = 0;
		for (int data : tArr) {
			if (data > t) {
				tOrder += (data % t == 0 ? data / t : data / t + 1);
			} else if (data != 0){
				tOrder += 1;
			}
		}

		// 결과 출력
		System.out.println(tOrder);
		System.out.println(num / p + " " + num % p);

	}
}