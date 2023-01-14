package lv1.q12947;

class Solution {
    // 2023.1.7(토) 17h15
    public boolean solution(int x) {
        boolean answer = true;
        
        int sum = 0;
        int copyX = x;
        while (copyX > 0) {
            sum = sum + copyX % 10;
            copyX = copyX / 10;
        }
        
        return x % sum == 0;
    }
}