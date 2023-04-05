import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
	
		String[][] map = new String[R][C];
		String[][] res = new String[R][C];
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int X = 0;
		for(int i = 0; i < R; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j < C; j++) {
				map[i][j] = str[j];
				res[i][j] = str[j];
				if(map[i][j].equals("X")) X++;
			}
		}
	
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				int cnt = 0;
				if(map[i][j].equals("X")) {
					for(int d = 0; d < 4; d++) {
						int nr = dr[d] + i;
						int nc = dc[d] + j;
						
						if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc].contains(".")) {
							cnt++;
							continue;
						}
					}
				}
				if(cnt >= 3) {
					res[i][j] = ".";
				}
			}
		}
		List<Integer> xlist = new ArrayList<>();
		List<Integer> ylist = new ArrayList<>();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(res[i][j].equals("X")) {
					xlist.add(i);
					ylist.add(j);
				}
			}
		}
		Collections.sort(xlist);
		Collections.sort(ylist);
		
		for(int i = xlist.get(0); i <= xlist.get(xlist.size() - 1); i++) {
			for(int j = ylist.get(0); j <= ylist.get(ylist.size() - 1); j++) {
				System.out.print(res[i][j]);
			}
			System.out.println();
		}
	}
}