import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int N;
    static int M;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        for(int tc= 1; tc <= 10; tc++){
     		sc.nextInt();
            N = sc.nextInt();
            M = sc.nextInt();
            int result = pow(N, M);
            
            System.out.printf("#%d %d\n", tc, result);
        }
	}
    public static int pow(int N, int M){
        if(M == 1) return N;
        
        if(M % 2 == 0){
            int x = pow(N, M / 2);
            return x * x;
        } else {
            int y = pow(N, (M - 1) / 2);
            return y * y * N;
        }
    }
}