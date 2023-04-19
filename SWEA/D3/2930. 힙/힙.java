import java.util.Scanner;

public class Solution {
	static int[] arr;
	static int lastIdx;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc);
			int N = sc.nextInt();
			
			arr = new int[N + 1];
			lastIdx = 0;
			
			for(int i = 0; i < N; i++) {
				int c = sc.nextInt();
				
				if(c == 1) {
					int num = sc.nextInt();
					arr[++lastIdx] = num;
					
					int cur = lastIdx; 
					
					while(cur > 1 && arr[cur] > arr[cur / 2]) {
						swap(cur, cur / 2); 
						cur = cur / 2; 
					}
					
				} else if(c == 2) {
					if(lastIdx < 1) sb.append(" ").append(-1);
					else {
						sb.append(" ").append(arr[1]);
						
						arr[1] = arr[lastIdx];
						arr[lastIdx--] = 0;

						int cur = 1;

						while(true) {
							int child = cur * 2;

							if(child + 1 <= lastIdx && arr[child] < arr[child + 1])
								child++;

							if(child > lastIdx || arr[child] < arr[cur]) break;
							
							swap(cur, child);
							cur = child;
						}
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void swap(int cur, int i) {
		int temp = arr[cur];
		arr[cur] = arr[i];
		arr[i] = temp;
	}
}