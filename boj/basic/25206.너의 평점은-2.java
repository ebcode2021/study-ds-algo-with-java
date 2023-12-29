import java.io.*;
import java.util.*;

/* 두 번째 풀이(배열 사용) */
public class Main {
	public static String[] subjectCode = {"A+", "A0","B+", "B0","C+", "C0","D+", "D0","F", "P"};
	public static double [] scores = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};

	public static double getScoreBySubjectCode(String code) {
		int index = Arrays.asList(subjectCode).indexOf(code);
		return scores[index];
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code; 
		double score;
		double totalScore = 0;
		double totalSum = 0;

		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			st.nextToken(); //useless data
			score = Double.parseDouble(st.nextToken());
			code = st.nextToken();
			if (code.equals("P"))
				continue;
			totalSum += score * getScoreBySubjectCode(code);
			totalScore += score;
		}
		System.out.printf("%.6f\n", totalSum / totalScore);
		br.close();
	}
}