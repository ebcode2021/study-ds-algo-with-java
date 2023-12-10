import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		short input = sc.nextShort();
		short iter = (short)(input / 4);

		for (short i = 0; i < iter; i++) {
			System.out.print("long ");
		}
		System.out.println("int");
	}
}