package com.programmers.lv1;

public class CollatzConjecture {
    // 2023.1.7(토) 17h -> 17h5 제출 시 테스트케이스 3번 틀림 -> 게시판 tips = 계산값이 int형을 넘는 경우가 나옴/몇번째 계산에서 음수로 바뀌어버림, 그거 처리해주시면 통과될 것임..
    public static int solution(int num) {
        if (num == 1) return 0;

        int answer = 0;

        while (num > 1) {
            answer++;
            if (num % 2 == 0) num /= 2;
            else num = num * 3 + 1;

            if (answer == 500 && num != 1) return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(626331)); // 104
    }
}
