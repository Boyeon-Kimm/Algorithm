import java.util.*;
import java.io.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long num = Long.parseLong(p);
        
        for(int i = 0; i < t.length() - p.length() + 1; i++) {
            if(t.charAt(i) <= p.charAt(0)){
                String temp = t.substring(i, i + p.length());
                if(num >= Long.parseLong(temp)) answer++;
            }
        }
        return answer;
    }
}