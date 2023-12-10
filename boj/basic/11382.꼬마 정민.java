import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 1. 기존 Scanner 클래스를 쓴 경우
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();

		System.out.println(a + b + c);

		// 2. 속도 개선
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long d = Long.parseLong(st.nextToken());
		long e = Long.parseLong(st.nextToken());
		long f = Long.parseLong(st.nextToken());
		System.out.println(d + e + f);
	}

}