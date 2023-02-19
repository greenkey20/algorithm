package com.programmers.lv1;

public class FoodFightCompetition {
    // 2023.2.19(일) 19h20 ~ 19h35 v1 의도하는대로 동작x
    // food[0] = 1 = 물의 양
    public static String solution(int[] food) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int quantityOfFood = food[i];

            for (int j = 0; j < quantityOfFood / 2; j++) {
                sb.append(i);
            }
        }

        sb.append("0");
        String reverseOfSb = sb.reverse().toString();
        sb.append(reverseOfSb);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 6})); // 1223330333221
        System.out.println(solution(new int[]{1, 7, 1, 2})); // 111303111
    }
}
