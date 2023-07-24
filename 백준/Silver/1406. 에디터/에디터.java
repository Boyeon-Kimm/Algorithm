import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> leftStack = new Stack<>();
		Stack<Character> rightStack = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			leftStack.push(str.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			switch(cmd) {
			case "L":
				if(!leftStack.isEmpty()) {
					rightStack.push(leftStack.pop());
				}
				break;
				
			case "D":
				if(!rightStack.isEmpty()) {
					leftStack.push(rightStack.pop());
				}
				break;
				
			case "B":
				if(!leftStack.isEmpty()) leftStack.pop();
				break;
				
			case "P":
				char ch = st.nextToken().charAt(0);
				leftStack.add(ch);
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!leftStack.isEmpty()) {
			rightStack.add(leftStack.pop());
		}
		while(!rightStack.isEmpty()) {
			sb.append(rightStack.pop());
		}
		System.out.println(sb);
	}
}