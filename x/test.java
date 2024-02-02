import java.io.*;
import java.util.*;

/// 666이 들어가야하고, N번째로 작은 종말의 수.
/**
 * 666 % 666
 * 1666 % 666
 * 2666 ...
 * 6660 ~ 6669
 * 7666 ... 9666
 * String으로 두고. 최소값이 666. 이어볼까?
 */
class test {
	public static void main(String[] args) throws IOException {
		Set<Integer> set = new TreeSet<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());

		int count = 0;
		int value = 666;
		while (set.size() < 10000) {
			if (String.valueOf(value).contains("666"))
				count++;
			if (num == count) {
				System.out.println(value);
				break ;
			}
			value++;
		}
	}
}