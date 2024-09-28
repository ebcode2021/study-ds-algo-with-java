import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		Set<String> sortedSet = new TreeSet<>((s1, s2) -> {
			int lengthCompare = Integer.compare(s1.length(), s2.length());
			return lengthCompare == 0 ? s1.compareTo(s2) : lengthCompare;
		});

		for (int i = 0; i < num; i++) {
			sortedSet.add(br.readLine());
		}

		sortedSet.forEach(System.out::println);
	}
}