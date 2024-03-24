import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dr = {1, 0};
    static int[] dc = {0, 1};
    static int[][] game;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        game = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = true;
        BFS(0, 0);

        System.out.println(visited[N - 1][N - 1] == true ? "HaruHaru" : "Hing");
    }

    public static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});

        if(x == N - 1 && y == N - 1) {
            visited[N - 1][N - 1] = true;
            return;
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int jump = game[curX][curY];

            for(int d = 0; d < 2; d++) {
                int nx = curX + dr[d] * jump;
                int ny = curY + dc[d] * jump;

                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}