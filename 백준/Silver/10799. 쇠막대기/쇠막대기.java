import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");
		Stack<String> stack = new Stack<>();
		
		int piece = 0;
		for(int i = 0; i < arr.length; i++) {
			String str = arr[i];
			
			if(str.equals("(")) stack.push(str);
			else {
				if(arr[i - 1].equals("(")) {
					stack.pop();
					piece += stack.size();
				} else {
					piece++;
					stack.pop();
				}
			}
		}
		System.out.println(piece);
	}
}