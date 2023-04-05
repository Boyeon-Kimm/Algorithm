import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		while(flag) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] num = new int[3];
			int cnt = 0;
			for(int i = 0; i < 3; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				if(num[i] == 0) cnt++;
			}
			if(cnt == 3) {
				flag = false;
				break;
			}
			Arrays.sort(num);
			
			if(num[0] * num[0] + num[1] * num[1] == num[2] * num[2])
				System.out.println("right");
			else System.out.println("wrong");
		}
	}
}