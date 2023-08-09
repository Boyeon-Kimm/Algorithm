import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
	
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i < X; i++) {
			sum += arr[i];
		}
		
		int cnt = 0;
		if(max < sum) {
			max = sum;
			cnt = 1;
		}
		
		for(int i = X; i < N; i++) {
			sum = sum - arr[i - X] + arr[i];
			if(sum > max) {
				max = sum;
				cnt = 1;
			} else if(sum == max) {
				cnt++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(max == 0) sb.append("SAD");
		else sb.append(max).append("\n").append(cnt);
		
		System.out.println(sb);
	}
}