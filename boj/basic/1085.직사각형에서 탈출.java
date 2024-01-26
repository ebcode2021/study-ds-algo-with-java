import java.io.*;
import java.util.*;

class test {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int rectX = Integer.parseInt(st.nextToken());
		int rectY = Integer.parseInt(st.nextToken());

		int minX = Math.abs(x - rectX) < Math.abs(rectX - x) ? Math.abs(x - rectX) : Math.abs(rectX - x);
		int minY = Math.abs(y - rectY) < Math.abs(rectY - y) ? Math.abs(y - rectY) : Math.abs(rectY - y);
		System.out.println(minX < minY ? minX : minY);
	}
}