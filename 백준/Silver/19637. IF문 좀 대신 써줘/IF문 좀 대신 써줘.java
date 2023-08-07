import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		String[] name = new String[N];
		int[] power = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			name[i] = st.nextToken();
			power[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		while(M-- > 0) {
			int energy = Integer.parseInt(br.readLine());
			
			int start = 0;
			int end = N - 1;
			
			while(start <= end) {
				int mid = (start + end) / 2;
				
				if(power[mid] < energy) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			sb.append(name[start]).append("\n");
		}
		System.out.println(sb.toString());
	}
}