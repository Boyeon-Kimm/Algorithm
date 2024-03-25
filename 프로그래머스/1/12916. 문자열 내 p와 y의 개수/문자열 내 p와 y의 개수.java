class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt = 0, yCnt = 0;
        s = s.toLowerCase();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == 'p') pCnt++;
            else if(ch == 'y') yCnt++;
        }
        
        return pCnt == yCnt ? true : false;
    }
}