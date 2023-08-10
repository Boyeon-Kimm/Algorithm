import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
		int max = Integer.MIN_VALUE;
		int right = N - 1;
		int left = 0;
		
		while(left <= right){
			int min = Math.min(arr[right], arr[left]);
			max = Math.max(max, min * (right - left - 1));
			
			if(arr[left] < arr[right]) left++;
			else right--;
		}
		System.out.println(max);
	}
}