package com.baekjoon.lv1.math;

import java.io.*;

// 2022.12.5(월) 10h30 -> 10h40 v1 틀렸습니다
public class Main2869 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int A = Integer.parseInt(inputs[0]); // 낮에 A미터 올라감
        int B = Integer.parseInt(inputs[1]); // 밤에 잠을 자는 동안 B미터 미끄러짐
        int V = Integer.parseInt(inputs[2]); // 높이가 V미터인 나무 막대

        // 문제 해결

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(calculateNumOfDaysToV(A, B, V)));

        bw.flush();
        bw.close();
        br.close();
    }

    // 문제 해결 로직
    public static int calculateNumOfDaysToV(int A, int B, int V) {
        /* 2022.12.8(목) 10h20 v2 -> 10h30 제출 시 '시간 초과' 오류
        질문 검색 결과 "위 문제는 반복문을 사용하면 시간초과가 발생할 수 있습니다. 반복문을 사용하지 않고도 수식만으로 해결가능하니 수식을 만들어서 처리하는 것이 좋을 것 같습니다"(https://www.acmicpc.net/board/view/101559)
         */
//        int positionBeforeSleep = 0;
//        int positionAfterSleep = 0;
        /*
        int position = 0;
        int days = 1;
        boolean isArrival = false;

        while (!isArrival) {
            position += A;

            if (position >= V) {
//                isArrival = true;
                break;
            }

            position -= B;
            days++;
        }

        return days;
         */

        // 종이에 입/출력 예시 그림 그려서 패턴 생각해봄 -> v3 11h5 맞았습니다
        // 하루에 올라갈 수 있는 높이(A)를 고려했을 때 실질적인 높이 = V - A
        // 실질적으로 하루에 올라가는 높이 = A - B
        int realHeight = V - A;
        int realMove = A - B;

//        int days = realHeight / realMove;
//        if (V - realHeight * realMove <= A) days++;

        return (int) Math.ceil((double) realHeight / realMove) + 1;
    }
}
