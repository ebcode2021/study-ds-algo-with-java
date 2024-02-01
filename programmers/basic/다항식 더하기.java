class Solution {
	// 1. 변수 : x
	// 2. 양의 정수. 공백. x. + 만 존재
	public String solution(String polynomial) {
		String[] polyno = polynomial.split(" ");
		int front = 0;
		int back = 0;
		
		for (String poly : polyno) {
			if (poly.equals("+"))
				continue;
			int len = poly.length();
			if (poly.indexOf('x') == -1) {
				back += Integer.parseInt(poly);
			}
			else {
				if (len == 1)
					front += 1;
				else 
					front += Integer.parseInt(poly.substring(0, len - 1));
			}
		}

		if (front == 0 && back != 0) {
			return Integer.toString(back);
		} else if (front != 0 && back == 0) {
			if (front == 1)
				return "x";
			return Integer.toString(front) + "x";
		} else {
			if (front == 1)
				return "x" + " + " + Integer.toString(back);
			return Integer.toString(front) + "x" + " + " + Integer.toString(back);
		}
	}
}