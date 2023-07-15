import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		Set<String> set = new HashSet<>();
		
		if(game.equals("Y")) {
			for(int i = 0; i < N; i++) {
				set.add(br.readLine());
			}
			System.out.println(set.size());
			return;
		} else if(game.equals("F")) {
			for(int i = 0; i < N; i++) {
				set.add(br.readLine());
			}
			System.out.println(set.size() / 2);
			return;
		} else {
			for(int i = 0; i < N; i++) {
				set.add(br.readLine());
			}
			System.out.println(set.size() / 3);
			return;
		}
	}
}