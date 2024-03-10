import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public int solution(int F, int S, int G, int U, int D) {
        int answer = 0;
        boolean[] visited = new boolean[F + 1];
        int[] dir = {U, -D};
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        visited[S] = true;

        if(S == G) return 0;

        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                int x = q.poll();
                for(int j = 0; j < 2; j++) {
                    int nx = x + dir[j];
                    if(nx == G) return answer + 1;
                    if(nx >= 1 && nx <= F && !visited[nx]) {
                        visited[nx] = true;
                        q.add(nx);
                    }
                }
            }
            answer++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Main T = new Main();

        int result = T.solution(F, S, G, U, D);
        if(result == -1) System.out.println("use the stairs");
        else System.out.println(result);
    }
}