import java.io.*;

class test {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String word = br.readLine();
		int wordLen = word.length();
		int compareCnt = wordLen / 2;
		int answer = 1;

		for (int i = 0; i < compareCnt; i++) {
			if (word.charAt(i) != word.charAt(wordLen - 1 - i)) {
				answer = 0;
				break;
			}
		}
		System.out.println(answer);
	}
}