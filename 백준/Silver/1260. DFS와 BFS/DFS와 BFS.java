import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        
        sb = new StringBuilder();
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        
        for(int i = 1; i <= n; i++){
            Collections.sort(list[i]);
        }
        
        dfs(v);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(v);
        System.out.println(sb);
    }
    
    public static void dfs(int Node){
        sb.append(Node + " ");
        visited[Node] = true;
        for(int i : list[Node]){
            if(!visited[i]) dfs(i);
        }
    }
    
    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        
        while(!queue.isEmpty()){
            int Node = queue.poll();
            sb.append(Node + " ");
            for(int i : list[Node]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}