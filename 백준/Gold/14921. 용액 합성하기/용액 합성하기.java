import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int start = 0;
		int end = N - 1;
		int min = Integer.MAX_VALUE;
		int a = 0;
		int b = 0;
		
		while(start < end) {
			int num = Math.abs(arr[start] + arr[end]);
		
			if(num < min) {
				min = num;
				a = arr[start];
				b = arr[end];
				
				if(num == 0) break;
			}
			if(arr[start] + arr[end] > 0) end--;
			else start++;
		}
		System.out.println(a + b);
	}
	
}