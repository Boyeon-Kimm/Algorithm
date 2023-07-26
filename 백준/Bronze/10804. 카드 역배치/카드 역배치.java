import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] card;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		card = new int[20];
		for(int i = 1; i <= 20; i++) {
			card[i - 1] = i;
		}
		
		for(int tc = 0; tc < 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
		
			Swap(start, end);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int n : card) {
			sb.append(n).append(" ");
		}
		System.out.println(sb);
	}

	public static void Swap(int start, int end) {
		int test = (end - start + 1) / 2;
		while(test-- > 0) {
			int temp = card[start];
			card[start] = card[end];
			card[end] = temp;
			
			start++;
			end--;
		}
	}
}