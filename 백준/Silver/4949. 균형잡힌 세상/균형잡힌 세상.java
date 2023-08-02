import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) break;
			
			Stack<Character> stack = new Stack<>();
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				if(ch == '[' || ch == '(') {
					stack.add(ch);
				} else if(ch == ']') {
					if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
					else stack.add(ch);
				} else if(ch == ')') {		
					if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
					else stack.add(ch);
				}
			}
			if(!stack.isEmpty()) sb.append("no").append("\n");
			else sb.append("yes").append("\n");
		}
		System.out.println(sb);
	}
}