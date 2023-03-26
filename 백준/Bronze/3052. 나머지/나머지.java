import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[42];
		for(int tc = 0; tc < 10; tc++) {
			int A = Integer.parseInt(br.readLine());
			num[A % 42]++;
		}
		int cnt = 0;
		for(int i = 0; i < 42; i++) {
			if(num[i] > 0) cnt++;
		}
		System.out.println(cnt);
	}
}
