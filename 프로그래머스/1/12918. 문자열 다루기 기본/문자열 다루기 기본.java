class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        int numCnt = 0;
        
        if(s.length() == 4 || s.length() == 6) {
            for(int i = 0; i < s.length(); i++) {
                if(Character.isAlphabetic(s.charAt(i))) return false;
                else numCnt++;
            }
        }
        
        if(numCnt == s.length()) answer = true;
        
        return answer;
    }
}