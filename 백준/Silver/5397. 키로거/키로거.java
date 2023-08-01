import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		Stack<Character> leftStack = new Stack<>();
		Stack<Character> rightStack = new Stack<>();
		
		while(tc-- > 0) {
			String str = br.readLine();
			
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				if(ch == '<' && !leftStack.isEmpty()) {
					rightStack.add(leftStack.pop());
				} else if(ch == '>' && !rightStack.isEmpty()) {
					leftStack.add(rightStack.pop());
				} else if(ch == '-' && !leftStack.isEmpty()) {
					leftStack.pop();
				} else if(ch != '<' && ch != '>' && ch != '-'){
					leftStack.add(ch);
				}
			}
			
			while(!leftStack.isEmpty()) {
				rightStack.add(leftStack.pop());
			}
			StringBuilder sb = new StringBuilder();
			while(!rightStack.isEmpty()) {
				sb.append(rightStack.pop());
			}
			System.out.println(sb);
		}
	}
}
