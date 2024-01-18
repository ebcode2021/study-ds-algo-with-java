import java.io.*;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCnt; i++) {
			String word = br.readLine();
			bw.write(word.charAt(0) + word.charAt(word.length()) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}