package com.programmers.lv1;

public class HarshadNumber {
    // 2023.1.7(토) 17h15 -> 17h20 제출 시 테스트케이스 3개 무한루프에 빠진 듯?
    public boolean solution(int x) {
        boolean answer = true;

        int sum = 0;
        int copyX = x;
        while (copyX >= 1) {
            copyX = copyX % 10;
            sum += copyX;
        }

        return sum % x == 0;
    }
}
