import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(stk.nextToken());
		}
	
		Arrays.sort(A);
		Arrays.sort(B);
		
		int cal = 0;
		for(int i = 0; i < N; i++) {
			cal += A[i] * B[N - i - 1];
		}
		System.out.println(cal);
	}
}