class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int lengthOfP = p.length();
        long numP = Long.parseLong(p); // Redundant boxing inside 'Integer.valueOf(p)'

        for (int i = 0; i <= t.length() - lengthOfP; i++) {
            long substringT = Long.parseLong(t.substring(i, i + lengthOfP));

            if (substringT <= numP) answer++;
        }
        
        return answer;
    }
}