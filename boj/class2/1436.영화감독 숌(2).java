import java.io.*;

/**
 * 종말이ㅡ 수 -> 6이 적어도 3개 이상
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		int value = 666;
		int count = 0;
		while (count != num) {
			if (String.valueOf(value).contains("666")) {
				count++;
			}
			if (count == num) {
				System.out.println(value);
			}
			value++;
		}
	}
	
	
}