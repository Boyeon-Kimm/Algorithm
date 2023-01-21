import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int[][] map = new int[9][9];
        int a = 0;
        int b = 0;
        
        for(int i = 0; i < map.length; i++){
            for(int j = 0 ; j < map.length; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] > max){
                    max = map[i][j];
                    a = i;
                    b = j;
                }
            }
        }
        sc.close();
        System.out.println(max);
        System.out.println(a+1 + " " + ++b);
    }
}