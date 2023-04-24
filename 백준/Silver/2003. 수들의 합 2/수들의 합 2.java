import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0;
		int sum = 0, cnt = 0;
		
		while(true) {
			if(sum >= M) sum -= num[start++];
			else if(end == N) break;
			else sum += num[end++];
			
			if(sum == M) cnt++;
		}
		
		System.out.println(cnt);
	}
}