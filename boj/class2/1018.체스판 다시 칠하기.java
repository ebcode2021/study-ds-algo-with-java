import java.io.*;

class test {
	
	static int reprintCnt(String[][] boards, int startRow, int startCol, int min) {
		int blackCurrent = 0;
		int whiteCurrent = 0;

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if ((row + col) % 2 == 0) {
					if (boards[row + startRow][col + startCol].equals("B") == true)
						blackCurrent += 1;
				} else {
					if (boards[row + startRow][col + startCol].equals("B") == false)
						blackCurrent += 1;
				}
			}
			if (min < blackCurrent)
				break ;
		}

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if ((row + col) % 2 == 0) {
					if (boards[row + startRow][col + startCol].equals("W") == true)
					whiteCurrent += 1;
				} else {
					if (boards[row + startRow][col + startCol].equals("W") == false)
					whiteCurrent += 1;
				}
			}
			if (min < whiteCurrent)
				break;
		}

		return Math.min(min, Math.min(blackCurrent, whiteCurrent));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 보드의 크기
		String input[] = br.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);

		String[][] boards= new String[m][n];

		for (int i = 0; i < m; i++) {
			String line = br.readLine();

			for (int j = 0; j < n; j++) {
				if (line.charAt(j) == 'B') {
					boards[i][j] = "B";
				} else {
					boards[i][j] = "W";
				}
			}
		}

		int rowCnt = m - 7;
		int colCnt = n - 7;
		
		int min = 10000;

		for (int row = 0; row < rowCnt; row++) {
			for (int col = 0; col < colCnt; col++) {
				int reprint = reprintCnt(boards, row, col, min);
				if (reprint < min) {
					min = reprint;
				}
			}
		}
		System.out.println(min);
	}
}