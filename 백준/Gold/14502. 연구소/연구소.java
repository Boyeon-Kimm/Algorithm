import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int max = Integer.MIN_VALUE;
    static int[][] map;
    static int[][] copyMap;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int wall) {
        if(wall == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        copyMap = new int[N][M];

        for(int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 2) q.add(new int[] {i, j});
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d = 0; d < 4; d++) {
                int nr = dr[d] + x;
                int nc = dc[d] + y;

                if(nr >= 0 && nc >= 0 && nr < N && nc < M && copyMap[nr][nc] == 0) {
                    copyMap[nr][nc] = 2;
                    q.add(new int[] {nr, nc});
                }
            }
        }
        safeZone(copyMap);
    }

    public static void safeZone(int[][] copyMap) {
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(copyMap[i][j] == 0) cnt++;
            }
        }
        max = Math.max(max, cnt);
    }
}