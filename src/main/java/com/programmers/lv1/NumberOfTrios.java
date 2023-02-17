package com.programmers.lv1;

// numbers 원소 중 3개 뽑기, 순서 상관 없음 = combination(조합)
public class NumberOfTrios {
    // 2023.2.17(금) 11h10 -> 11h20 맞았습니다
    public static int solution(int[] numbers) {
        int answer = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    if (numbers[i] + numbers[j] + numbers[k] == 0) answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-2, 3, 0, 2, -5})); // 2
        System.out.println(solution(new int[]{-3, -2, -1, 0, 1, 2, 3})); // 5
        System.out.println(solution(new int[]{-1, 1, -1, 1})); // 0
    }
}
