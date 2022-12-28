class Solution {
    // 2022.12.29(목) 0h25
    public String solution(String[] seoul) {
        int i = 0;
        
        for (i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) break;
        } 
        
        return "김서방은 " + i + "에 있다";
    }
}