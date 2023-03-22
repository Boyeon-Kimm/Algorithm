import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
        
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max < arr[i]) max = arr[i];
			if(min > arr[i]) min = arr[i];
		}
		System.out.println(min + " " + max);
	}
}
