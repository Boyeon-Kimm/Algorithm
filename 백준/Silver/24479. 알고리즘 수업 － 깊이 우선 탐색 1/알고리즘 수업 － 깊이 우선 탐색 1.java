import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] check;
    static int num = 1;
    public static void DFS(int R) {
        check[R] = num;

        for(int i = 0; i < graph.get(R).size(); i++) {
            int newR = graph.get(R).get(i);

            if(check[newR] == 0) {
                num++;
                DFS(newR);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        check = new int[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        DFS(R);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < check.length; i++) {
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb);
    }

}