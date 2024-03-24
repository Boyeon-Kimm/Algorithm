import java.util.*;
import java.io.*;

class Solution {
    static int n, m;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        visited[0][0] = true;
        q.offer(new int[] {0, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int d = 0; d < 4; d++) {
                int nx = dr[d] + x;
                int ny = dc[d] + y;
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    maps[nx][ny] = maps[x][y] + 1;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }
}