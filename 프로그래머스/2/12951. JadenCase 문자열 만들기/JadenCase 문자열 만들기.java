class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        s = s.toLowerCase();
        boolean isNewWord = true;
        
        for(char c : s.toCharArray()) {
            if(c == ' ') isNewWord = true;
            else if(isNewWord) {
                isNewWord = false;
                c = Character.toUpperCase(c);
            }
            answer.append(c);
        }
        return answer.toString();
    }
}