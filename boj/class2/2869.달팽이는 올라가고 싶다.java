import java.io.*;
import java.util.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int dailyMove = Integer.parseInt(st.nextToken());
		int nightMove = Integer.parseInt(st.nextToken());
		int wood = Integer.parseInt(st.nextToken());

		int diff = dailyMove - nightMove;
		int remainDistance = wood - dailyMove;

		int days = (int)Math.ceil((double) remainDistance / diff) + 1;
		System.out.println(days);
	}
}