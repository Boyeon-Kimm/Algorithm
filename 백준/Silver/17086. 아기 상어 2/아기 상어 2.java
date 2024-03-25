import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] ocean;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ocean = new int[N][M];
        visited = new int[N][M];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                ocean[i][j] = Integer.parseInt(st.nextToken());
                if(ocean[i][j] == 1) {
                    q.add(new int[] {i, j});
                    visited[i][j] = 0;
                } else visited[i][j] = -1;
            }
        }
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int d = 0; d < 8; d++) {
                int nx = dr[d] + curX;
                int ny = dc[d] + curY;

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[curX][curY] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(max < visited[i][j]) max = visited[i][j];
            }
        }
        System.out.println(max);
    }
}