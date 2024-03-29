package com.baekjoon.lv2silver.bruteforce;

import java.io.IOException;

// 2022.12.13(화) 0h30 -> 0h55 일단 v1 = 1~1만 모든 숫자가 출력됨 -> 2022.12.14(수) 13h40 맞았습니다!
// 종이에 d(1), d(2), d(3), .. 써가며 self number 개념 이해
public class Main4673 {
//    static ArrayList<Integer> listOfNums = new ArrayList<>();
    static boolean[] isDerivationOfN = new boolean[10000]; // 2022.12.14(수) 13h15 v3 여전히 1~10000 모든 숫자가 출력되는데, 어느 부분이 문제인지 잘 모르겠음 = 이건 내가 getListOfSelfNums() 함수 호출을 안 해서

    public static void main(String[] args) throws IOException {
        // 입력 = 없음
        // 단, 문제에서 10,000보다 작거나 같은 self numbers를 구하라는 조건 주어짐
//        for (int i = 1; i <= 10000; i++) {
//            listOfNums.add(i);
//        }

        // 문제 해결 로직
        getListOfSelfNums();

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < isDerivationOfN.length; i++) {
            if (!isDerivationOfN[i]) {
                sb.append((i + 1) + "\n");
            }
        }

        System.out.println(sb);
    }

    // 2022.12.14(수) 12h55 이어서 생각해봄 -> 13h5 v2 제출 시 '출력 초과'라 구글링해서 출력 부분 해설 간단히 봄 + 실행해 보니 1~10000 모든 숫자가 출력됨
    public static void getListOfSelfNums() {
        int n = 0;
        int derivativeOfN = 0;

        for (int i = 0; i < 10000; i++) {
            n = i + 1;
            derivativeOfN = n;

            while (n > 0) {
                derivativeOfN += n % 10;
                n = n / 10;
            }

//            System.out.println(i + 1 + "의 derivativeOfN = " + derivativeOfN);

//            listOfNums.remove(derivativeOfN); // 이 메서드 설명 다시 읽어보니 매개변수로 주어진 수의 위치에 있는 요소를 삭제하는 것임 != 내가 의도한 것
            if (derivativeOfN <= 10000) { // 10000보다 작거나 같은 self number를 찾고 있는데, 위 for문에서 10000까지 검사했기 때문에 10000을 초과하는 바, index out of bounds 예외가 나오지 않으려면 이 조건 필요
                isDerivationOfN[derivativeOfN - 1] = true;
            }
        }
    }
}
