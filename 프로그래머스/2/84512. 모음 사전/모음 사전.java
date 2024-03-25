import java.util.*;

class Solution {
    Set<String> set;
    String[] alphabet = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        set = new TreeSet<>();
        
        for(int i = 0; i < 5; i++) {
            makeWord(alphabet[i], 1);
        }
        
        for(String s : set) {
            answer++;
            if(word.equals(s)) return answer;
        }
        return answer;
    }
    
    public void makeWord(String base, int depth) {
        set.add(base);
        
        if(depth == 5) return;
        
        for(int i = 0; i < 5; i++) {
            makeWord(base + alphabet[i], depth + 1);
        }
    }
}