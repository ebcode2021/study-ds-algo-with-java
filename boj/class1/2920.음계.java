import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] ascending = {"1", "2", "3", "4", "5", "6", "7", "8"};
		String[] descending = {"8", "7", "6", "5", "4", "3", "2", "1"};
		String[] song = br.readLine().split(" ");

		if (Arrays.equals(song, ascending))
			bw.append("ascending");
		else if (Arrays.equals(song, descending))
			bw.append("descending");
		else
			bw.append("mixed");
		
		br.close();
		bw.flush();
		bw.close();
	}
}