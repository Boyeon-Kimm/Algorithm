import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";
        int max = Integer.MIN_VALUE;

        outer:
        while(true) {
            String[] arr = br.readLine().trim().split(" ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i].replaceAll("[^a-zA-Z-]", " ").trim();
                String[] temp = arr[i].split(" ");

                for(int j = 0; j < temp.length; j++) {
                    if(temp[j].equals("E-N-D")) break outer;
                    if (max < temp[j].length()) {
                        max = temp[j].length();
                        answer = temp[j];
                    }
                }
            }
        }
        System.out.println(answer.toLowerCase());
    }
}