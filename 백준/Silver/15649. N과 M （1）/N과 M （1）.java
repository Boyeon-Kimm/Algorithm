import java.util.Scanner;
public class Main{
    static int n, m;
    static int[] arr = new int[9];
    static boolean[] visited = new boolean[9];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        bt(0);
    }
    static void bt(int k){
        if(k == m){
            for(int i = 0; i < m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                arr[k] = i;
                visited[i] = true;
                bt(k + 1);
                visited[i] = false;
            }
        }
    }
}