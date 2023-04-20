import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}
        if(pq.peek() >= K) return 0;
        
        boolean flag = true;
		while(pq.size() > 1) {
			answer++;
            int a = pq.remove();
			int b = pq.remove() * 2;
			pq.add(a + b);
            
			if(pq.peek() >= K) {
                flag = false;
                break;
            }
		}
        if(!flag) return answer;
        else return -1;
    }
}