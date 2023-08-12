import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = left + 1;
		int sum = arr[left];
		int min = Integer.MAX_VALUE;
		
		while(true) {
			if(sum >= S) {
				sum -= arr[left++];
				min = Math.min(min, right - left + 1);
			} else if(right == N) break;
			else sum += arr[right++];
		}
		System.out.println((min) == Integer.MAX_VALUE ? 0 : min);
	}
}