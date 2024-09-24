import java.io.*;

/**
 * 15의 배수 -> FizzBuzz
 * 3의 배수면서 5의 배수가 아니면 -> Fizz
 * 3의 배수가 아니면서 5의 배수 -> Buzz
 * 아무것도 아닌 경우 -> i를 그대로 출력
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int value = -1;
		int location = -1;

		for (int i = 0; i < 3; i++) {
			String input = br.readLine();

			if (!input.contains("zz")) {
				value = Integer.parseInt(input);
				location = i;
			}
		}
		
		if (location == 0) {
			value += 3;
		} else if (location == 1) {
			value += 2;
		} else {
			value += 1;
		}

		if (value % 5 == 0 && value % 3 == 0) {
			System.out.println("FizzBuzz");
		} else if (value % 3 == 0) {
			System.out.println("Fizz");
		} else if (value % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(value);
		}


	}
}