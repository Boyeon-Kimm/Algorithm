import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] arrN = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrN);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(M-- > 0) {
			int num = Integer.parseInt(st.nextToken());
			
			int start = 0;
			int end = N - 1;
			int mid = 0;
			int ans = 0;
			
			while(start <= end) {
				mid = (start + end) / 2;
				
				if(num == arrN[mid]) {
					ans = 1;
					break;
				}
				else if(num > arrN[mid]) start = mid + 1;
				else if(num < arrN[mid]) end = mid - 1;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}