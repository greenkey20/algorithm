package com.baekjoon.lv2silver.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 2022.12.24(토) 4h50 문제 읽음
// 입력으로 주어진 숫자 하나하나 읽으며 set에 담고, set에 있으면 새로운 세트 만듦(단, 6이나 9인 경우 set에 있다면 각각 9/6으로 바꿔서 set에 있는지 다시 검사) -> set를 담는 list를 만들고, 최종적으로 그 list의 size를 반환
public class Main1475 {
    // 2022.12.24(토) 19h15 구현 시작 -> 입/출력 예시는 다 통과했지만 19h35 제출 시 틀렸습니다 -> 반례 9999444로 디버깅
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strN = br.readLine();

        // 문제 해결 로직

        // 출력
        System.out.println(getNumOfDigitSet(strN));

    }

    public static int getNumOfDigitSet(String strN) {
        // N으로 주어진 수의 각 자리 수를 오름차순으로 정렬하고 시작
        int[] digitsOfN = new int[strN.length()];
        for (int i = 0; i < strN.length(); i++) {
            digitsOfN[i] = Character.getNumericValue(strN.charAt(i));
        }
        Arrays.sort(digitsOfN);

        int result = 1;
        boolean[] digitSet1 = new boolean[10];

        for (int i = 0; i < strN.length(); i++) {
            int num = Character.getNumericValue(strN.charAt(i));

            if (!digitSet1[num]) {
                digitSet1[num] = true;
            } else if (num == 6 && !digitSet1[9]) {
                digitSet1[9] = true;
            } else if (num == 9 && !digitSet1[6]) {
                digitSet1[6] = true;
            } else {
                result++;
                digitSet1 = new boolean[10];
                digitSet1[num] = true;
            }

            System.out.println("num = " + num + ", result = " + result + ", digitSet[num] = " + digitSet1[num]);
        }

        return result;
    }
}

/* ideation
boolean exists6 = false;
boolean exists9 = false;

List<HashSet<Integer>> list = new ArrayList<>();
Set<Integer> set1 = new HashSet<>();

if (!set1.contains(num)) {
    set1.add(num);
} else if (num == 6) {
    if (!exists9) {

    }

}

if (set1.contains(num) && (!(num == 9 || num == 6))) {
    result++;
    Set<Integer> newSet = new HashSet<>();
    newSet.add(num);
    list.add(new HashSet<>());
}
 */
