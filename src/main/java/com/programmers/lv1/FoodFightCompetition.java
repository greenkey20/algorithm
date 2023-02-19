package com.programmers.lv1;

public class FoodFightCompetition {
    // 2023.2.19(일) 19h20 ~ 19h35 v1 의도하는대로 동작x -> 19h50 v2 입/출력 예시에 대해서는 동작하는 듯
    // food[0] = 1 = 물의 양
    public static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
//        int count = 0;

        for (int i = 1; i < food.length; i++) {
            int quantityOfFood = food[i];

            for (int j = 0; j < quantityOfFood / 2; j++) {
                sb.append(i);
//                count++;
//                System.out.println("sb.toString() = " + sb.toString() + ", count = " + count); // todo
                System.out.println("sb.toString() = " + sb.toString()); // todo
            }
        }

        String competitorOne = sb.toString();

        sb.append("0");

        for (int i = competitorOne.length() - 1; i >= 0; i--) {
            sb.append(competitorOne.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 6})); // 1223330333221
        System.out.println(solution(new int[]{1, 7, 1, 2})); // 111303111
    }
}
