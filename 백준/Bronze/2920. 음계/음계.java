import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[8];
		int[] asc = new int[8];
		int[] des = new int[8];
		
		for(int i = 0; i < 8; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			asc[i] = i + 1;
			des[i] = 8 - i;
		}
		int a = 0;
		int d = 0;

		for(int i = 0; i < 8; i++) {
			if(num[i] == asc[i]) {
				a++;
			} else if(num[i] == des[i]){
				d++;
			}
		}
		if(a == 8) System.out.println("ascending");
		else if(d == 8) System.out.println("descending");
		else System.out.println("mixed");
	}
}
