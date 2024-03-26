import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int min = Integer.MAX_VALUE;
    static int[] selected;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value == 1) house.add(new int[] {i, j});
                else if(value == 2) chicken.add(new int[] {i, j});
            }
        }
        dfs(0, 0);
        System.out.println(min);
    }

    public static void dfs(int L, int start) {
        if(L == M) {
            dist();
            return;
        }

        for(int i = start; i < chicken.size(); i++) {
            selected[L] = i;
            dfs(L + 1, i + 1);
        }
    }

    public static void dist() {
        int sum = 0;
        for(int[] h : house) {
            int tempMin = Integer.MAX_VALUE;
            for(int idx : selected) {
                int[] hCur = chicken.get(idx);
                int distance = Math.abs(h[0] - hCur[0]) + Math.abs(h[1] - hCur[1]);
                tempMin = Math.min(tempMin, distance);
            }
            sum += tempMin;
        }
        min = Math.min(sum, min);
    }
}