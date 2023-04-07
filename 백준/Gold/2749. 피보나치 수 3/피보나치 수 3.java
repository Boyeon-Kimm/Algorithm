import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int pisano = 1500000;
		long size = Long.parseLong(br.readLine()) % pisano;

		long[] fibo = new long[pisano + 1];
		fibo[1] = 1;
		
		for(int i = 2; i <= pisano; i++) {
			fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000;
		}
		System.out.println(fibo[(int)size]);
	}
}