import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int[][] ocean;
    static boolean[][] visited;
    static List<int[]> icebergs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ocean = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                ocean[i][j] = Integer.parseInt(st.nextToken());
                if(ocean[i][j] > 0) {
                    icebergs.add(new int[] {i, j});
                }
            }
        }

        int time = 0;
        while(!icebergs.isEmpty()){
            time++;
            melting();

            if(searchSplit()) {
                System.out.println(time);
                return;
            }
        }
        System.out.println(0);
    }
    public static void melting() {
        int[][] tempMap = new int[N][M];
        List<int[]> nextIcebergs = new ArrayList<>();

        for(int[] iceberg : icebergs) {
            int x = iceberg[0];
            int y = iceberg[1];

            int melt = 0;
            for(int d = 0; d < 4; d++) {
                int nx = dr[d] + x;
                int ny = dc[d] + y;

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && ocean[nx][ny] == 0) melt++;
            }
            tempMap[x][y] = Math.max(0, ocean[x][y] - melt);
            if(tempMap[x][y] > 0) nextIcebergs.add(new int[] {x, y});
        }

        icebergs = nextIcebergs;
        for(int i = 0; i < N; i++) {
            System.arraycopy(tempMap[i], 0, ocean[i], 0, M);
        }
    }

    public static boolean searchSplit() {
        int count = 0;
        for(boolean[] row : visited) Arrays.fill(row, false);

        for(int[] iceberg : icebergs) {
            int x = iceberg[0];
            int y = iceberg[1];

            if(!visited[x][y]) {
                dfs(x, y);
                count++;
                if(count > 1) return true;
            }
        }
        return false;
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int d = 0; d < 4; d++) {
            int nx = dr[d] + x;
            int ny = dc[d] + y;

            if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && ocean[nx][ny] > 0) {
                dfs(nx, ny);
            }
        }
    }
}