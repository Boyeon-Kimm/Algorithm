import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] time, in_degree, ans;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		in_degree = new int[N + 1];
		time = new int[N + 1];
		ans = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if(num == -1) break;
				
				list[num].add(i);
				in_degree[i]++;
			}
		}
		TopologicalSort();
		
		for(int i = 1; i <= N; i++) {
			System.out.println(ans[i]);
		}
	}
	static void TopologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(in_degree[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int v = q.remove();
			ans[v] += time[v];
			
			for(int i = 0; i < list[v].size(); i++) {
				int next = list[v].get(i);
				
				in_degree[next]--;
				if(in_degree[next] == 0) q.add(next);
				
				ans[next] = Math.max(ans[next], ans[v]);
			}
		}
	}
}