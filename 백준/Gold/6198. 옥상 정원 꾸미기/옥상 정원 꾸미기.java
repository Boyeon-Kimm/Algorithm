import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		long cnt = 0;
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			while(!stack.isEmpty()) {
				if(stack.peek() <= num) {
					stack.pop();
				} else break;
			}
			cnt += stack.size();
			stack.push(num);
		}
		System.out.println(cnt);
	}
}