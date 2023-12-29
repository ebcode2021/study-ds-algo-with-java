import java.io.*;
import java.util.*;

/* 첫 번째 풀이(switch문 사용) */
public class Main {

	public static double getGradeToValue(String grade) {
		switch (grade) {
			case "A+" :
				return 4.5;
			case "A0" :
				return 4.0;
			case "B+" :
				return 3.5;
			case "B0" :
				return 3.0;
			case "C+" :
				return 2.5;
			case "C0" :
				return 2.0;
			case "D+" :
				return 1.5;
			case "D0" :
				return 1.0;
			default:
				return 0;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double	totalSum = 0;
		int		totalScore = 0;
		double		score;
		String		grade;

		for (int i = 0; i < 20; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			score = Double.parseDouble(st.nextToken());
			grade = st.nextToken();
			if (grade.equals("P")) {
				continue;
			}
			totalSum += score * getGradeToValue(grade);
			totalScore += score;
		}
		System.out.printf("%.6f\n", totalSum / totalScore);
		br.close();
	}
}
