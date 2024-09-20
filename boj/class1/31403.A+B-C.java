import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();

		int d = Integer.parseInt(a + b);

		bw.write(Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c) + "\n");
		bw.write(d - Integer.parseInt(c) + "\n");
		
		bw.flush();
		bw.close();
	}
}