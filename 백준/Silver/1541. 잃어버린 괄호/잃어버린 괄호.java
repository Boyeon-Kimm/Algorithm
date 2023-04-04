import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("-");
		int res = 0;
		for(int i = 0; i < str.length; i++) {
			int num = 0;
			String[] add = str[i].split("\\+");
			for(int j = 0; j < add.length; j++) {
				num += Integer.parseInt(add[j]);
			}
			if(i == 0) res = num;
			else res -= num;
		}
		System.out.println(res);
	}
}