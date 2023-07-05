import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int[] arr = new int[10];
		
		int reverse = 0;
		for(int i = 0; i < str.length(); i++) {
			int num = str.charAt(i) - '0';
			if(num == 6 || num == 9) reverse++;
			else arr[num]++;
		}
		
		int max = Integer.MIN_VALUE;
		
		if(reverse % 2 == 0) max = reverse / 2;
		else max = reverse / 2 + 1;
		
		for(int i = 0; i < 9; i++) {
			max = Math.max(arr[i], max);
		}
		
		System.out.println(max);
		
	}
}