import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		int sum = 0;
		
		for(int i = 0; i < 7; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num % 2 == 1) {
				list.add(num);
				min = Math.min(num, min);
				sum += num;
			}
		}
		
		if(list.isEmpty()) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(sum);
		System.out.println(min);
		
	}
}