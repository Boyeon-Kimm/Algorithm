import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int left = 0;
		int right = left + 1;
		int min = Integer.MAX_VALUE;
		int subtract = 0;
		
		Arrays.sort(arr);
		
		while(right < N) {
			subtract = arr[right] - arr[left];
			
			if(subtract >= M) {
				min = Math.min(subtract, min);
				left++;
				right = left + 1;
			} else {
				right++;
			}
		}
		System.out.println(min);
	}
}
