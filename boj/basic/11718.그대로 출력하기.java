import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
	}
}

class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext())
			System.out.println(sc.nextLine());
	}
}