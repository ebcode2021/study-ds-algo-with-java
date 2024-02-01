import java.io.*;
import java.util.*;

class test {
	public static void main(String[] args) throws IOException {
		List<String> dictionary = new LinkedList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			dictionary.add(br.readLine());
		}

		dictionary.sort((o1, o2) -> {
			if (o1.length() == o2.length())
				return o1.compareTo(o2);
			return o1.length() - o2.length();
		});

	}
}