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
		int[] num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
        int sum = 0;
		for(int i = 1; i < (1 << N); i++) {
			sum = 0;
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) > 0){
					sum += num[j];
				}
			}
			if(sum == S) cnt++;
		}
		System.out.println(cnt);
	}
}
