import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Set<String> set;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[5][5];

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        set = new HashSet<>();
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                DFS(i, j, "", 0);
            }
        }
        System.out.println(set.size());
    }

    public static void DFS(int x, int y, String result, int count) {
        if(count == 6) {
            set.add(result);
            return;
        }

        for(int d = 0; d < 4; d++) {
            int nr = dr[d] + x;
            int nc = dc[d] + y;

            if(nr >= 0 && nc >= 0 && nr < 5 && nc < 5) {
                DFS(nr, nc, result + map[nr][nc], count + 1);
            }
        }
    }
}