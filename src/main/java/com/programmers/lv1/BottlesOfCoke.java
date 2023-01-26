package com.programmers.lv1;

public class BottlesOfCoke {
    // 2023.1.26(목) 11h40 -> 11h55 v1 문제 요구사항대로 동작x -> v2 입/출력 예시 2개는 통과하는데, 채점 시 1개 테스트만 통과
    // 2023.1.26(목) 13h15 나의 생각 = 예를 들어 빈영 3개 가져다주면 콜라 2병을 주는 경우에 대해 현재 처리 못함
    public static int solution(int a, int b, int n) {
        int answer = 0;
        int currentNumOfEmptyBottles = 0;

        boolean flag = true;
        while (flag) {
            currentNumOfEmptyBottles = n / a + n - (n / a) * a;
            answer = answer + n / a;
            n = currentNumOfEmptyBottles;

            if (currentNumOfEmptyBottles < a) flag = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 1, 20)); // 19
        System.out.println(solution(3, 1, 20)); // 9
    }
}
