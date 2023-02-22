package com.programmers.lv1;

public class WeaponOfKnights {
    // 2023.2.22(수) 22h ~ 22h20 v1 시간 초과 때문에 정확성 66.7%로 실패 -> 2중 for문 때문인 것 같은데, 어떻게 개선해야 할까..?
    public static int solution(int numberOfKnights, int limit, int power) {
        int answer = 0;

        // 1~numberOfKnights 범위 자연수의 약수의 개수를 각각 구하고, 각 약수의 개수가 limit를 초과하는 경우 해당 값을 power로 바꿈
        for (int i = 1; i <= numberOfKnights; i++) {
            int numberOfKnight = i;
            int weapon = 0;

            for (int j = 1; j <= numberOfKnight; j++) {
                if (numberOfKnight % j == 0) weapon++;
            }

            if (weapon > limit) weapon = power;
//            System.out.println(numberOfKnight + "번 기사의 weapon = " + weapon); // todo

            answer += weapon;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 3, 2)); // 10
        System.out.println(solution(10, 3, 2)); // 21
    }
}
