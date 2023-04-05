import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] ch = br.readLine().toCharArray();
		char[][] maze = new char[101][101];
		
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, -1, 0, 1};
		int d = 0;
		int x = 50, y = 50;
		
		for(int i = 0; i < 101; i++) {
			Arrays.fill(maze[i], '#');
		}
		
		maze[x][y] = '.';
		
		int minX = 50;
		int minY = 50;
		int maxX = 50;
		int maxY = 50;
		
		for(int i = 0; i < ch.length; i++) {
			switch(ch[i]) {
				case 'R' :
					if(d == 3) d = 0;
					else d++;
					break;
			
				case 'F' :
					x += dr[d];
					y += dc[d];
					maze[x][y] = '.';
					minX = Math.min(minX, x);
					minY = Math.min(minY, y);
					maxX = Math.max(maxX, x);
					maxY = Math.max(maxY, y);
					break;
					
				case 'L' :
					if(d == 0) d = 3;
					else d--;
					break;
			}
		}
		
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}
}