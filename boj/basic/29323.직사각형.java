import java.io.*;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int length = Integer.parseInt(br.readLine());
		int height = Integer.parseInt(br.readLine());

		System.out.println(length * height);
		
	}
}