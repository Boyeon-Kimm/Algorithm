import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Character> key = new HashSet<>();

        loop:
        for(int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");

            for(int j = 0; j < arr.length; j++) {
                if(!key.contains(arr[j].charAt(0))) {
                    key.add(Character.toLowerCase(arr[j].charAt(0)));
                    key.add(Character.toUpperCase(arr[j].charAt(0)));

                    StringBuilder sb = new StringBuilder(arr[j]);
                    sb.insert(0, "[");
                    sb.insert(2, "]");
                    arr[j] = sb.toString();

                    printAnswer(arr);
                    continue loop;
                }
            }
            for(int j = 0; j < arr.length; j++) {
                for(int k = 1; k < arr[j].length(); k++) {
                    if(!key.contains(arr[j].charAt(k))) {
                        key.add(Character.toLowerCase(arr[j].charAt(k)));
                        key.add(Character.toUpperCase(arr[j].charAt(k)));

                        StringBuilder sb = new StringBuilder(arr[j]);
                        sb.insert(k, "[");
                        sb.insert(k + 2, "]");
                        arr[j] = sb.toString();

                        printAnswer(arr);
                        continue loop;
                    }
                }
            }
            printAnswer(arr);
        }
    }

    public static void printAnswer(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1) sb.append(arr[i]);
            else sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}