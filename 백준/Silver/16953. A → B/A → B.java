import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
   public int solution(int A, int B) {
       int answer = 1;
       boolean[] visited = new boolean[B + 1];
       Queue<Integer> q = new LinkedList<>();
       q.add(A);
       visited[A] = true;
       if(A == B) return answer;

       while(!q.isEmpty()) {
           int len = q.size();
           for(int i = 0; i < len; i++) {
               int x = q.poll();
               for(int j = 0; j < 2; j++) {
                   long nx = 0;
                   if(j == 0) nx = x * 2L;
                   else nx = x * 10L + 1;
                   if(nx == B) return answer + 1;
                   if(nx <= B && !visited[(int)nx]) {
                       visited[(int)nx] = true;
                       q.add((int)nx);
                   }
               }
           }
           answer++;
       }
       return -1;
   }

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int A = sc.nextInt();
       int B = sc.nextInt();
       Main T = new Main();

       System.out.println(T.solution(A, B));
   }
}