class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"};

        for(String s : babbling) {
            for(int i = 0 ; i < arr.length; i++) {
                if(s.contains(arr[i])) {
                    s = s.replace(arr[i], " ");
                    if(s.strip() == "") answer++;
                }
            }
        }
        return answer;
    }
}