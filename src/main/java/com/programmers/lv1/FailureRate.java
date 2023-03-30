package com.programmers.lv1;

import java.util.Arrays;
import java.util.Collections;

// 2023.3.30(목) 23h45 ~ 0h55 v1 아직 완성 못함, 실패율 배열을 내림차순 정렬하는 데까지 구현..
public class FailureRate {
    public static int[] solution(int n, int[] stages) {
        int[] answer = new int[n];
        Double[] counts = new Double[n];

        for (int i = 0; i < n; i++) {
            counts[i] = 0.0;
        }

        Arrays.sort(stages);
        System.out.println("오름차순으로 정렬된 배열 stages = " + Arrays.toString(stages)); // todo

        boolean completed = false;
        for (int i = 0; i < stages.length; i++) {
            int stage = stages[i];

            for (int j = 1; j <= n; j++) {
                if (stage == n + 1) {
                    counts[n - 1]++;
                    completed = true;
                    break;
                } else if (stage == j) {
                    counts[j - 1]++;
                }
//                counts[j - 1]++; // 이렇게 하면 counts 배열 제대로 안 만들어짐

                //System.out.println("stage = " + stage + ", j = " + j + ", counts 배열 = " + Arrays.toString(counts)); // todo
            }
        }

        System.out.println("counts 배열 = " + Arrays.toString(counts)); // todo

        Double[] failureRates = new Double[n];

        for (int i = 0; i < n; i++) {
            int numOfChallengers = 0;

            if (i == n - 1 && completed ) {
                failureRates[i] = 0.0;
                break;
            } else {
                for (int j = n - 1; j >= i; j--) {
                    numOfChallengers += counts[j];
                    //System.out.println(numOfChallengers); // todo 이 변수는 잘 쌓이고 있는 것 같다
                }
            }

            failureRates[i] = (Double) counts[i] / numOfChallengers;
        }

        Arrays.sort(failureRates, Collections.reverseOrder());
        System.out.println("실패율 배열 = " + Arrays.toString(failureRates)); // todo
        // 실패율 배열의 원소들을 내림차순으로 정렬까지는 했는데, 각 원소가 몇 번 stage였었는지를 파악해서, 그 stage들의 순서를 담은 배열을 return해야 한다..

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}))); // 3, 4, 2, 1, 5
        System.out.println(Arrays.toString(solution(4, new int[]{4, 4, 4, 4}))); // 4, 1, 2, 3
    }
}
