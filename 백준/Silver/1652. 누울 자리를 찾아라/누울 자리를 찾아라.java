import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] room = new char[N][N];
		
		int rowSleep = 0;
		int colSleep = 0;
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				room[i][j] = str.charAt(j);
			}
		}

		for(int i = 0; i < N; i++) {
			int rowCnt = 0;
			int colCnt = 0;
			for(int j = 0; j < N; j++) {
				if(room[i][j] == '.') rowCnt++;
				if(room[i][j] == 'X' || j == N - 1) {
					if(rowCnt >= 2) rowSleep++;
					rowCnt = 0;
				}
				if(room[j][i] == '.') colCnt++;
				if(room[j][i] == 'X' || j == N - 1) {
					if(colCnt >= 2) colSleep++;
					colCnt = 0;
				}
			}
		}
		System.out.println(rowSleep + " " + colSleep);
	}
}