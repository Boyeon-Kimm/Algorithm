import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
	
		int destination = V - B;
		int distance = A - B;
		
		int day = destination / distance;
		int mod = destination % distance;
		
		if(mod != 0) System.out.println(day + 1);
		else System.out.println(day);
	}
}