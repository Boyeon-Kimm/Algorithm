import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 3; i++) {
			int[] arr = new int[2];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				arr[Integer.parseInt(st.nextToken())]++;
			}
			if(arr[1] == 4) System.out.println("E");
			else if(arr[0] == 4) System.out.println("D");
			else if(arr[0] == 3) System.out.println("C");
			else if(arr[0] == 2) System.out.println("B");
			else System.out.println("A");
		}
	}
}