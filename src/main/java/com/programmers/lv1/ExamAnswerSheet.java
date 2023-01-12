package com.programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExamAnswerSheet {
    // 2023.1.12(목) 8h25
    public static int[] solution(int[] answers) {
        int numOfQuestions = answers.length;

        // 학생1~3의 1~1만번 문제에 대한 답안지를 만듦
        String student1 = "1,2,3,4,5,";
        String student2 = "2,1,2,3,2,4,2,5,";
        String student3 = "3,3,1,1,2,2,4,4,5,5,";
        String[] students = new String[]{student1, student2, student3};

        int repeat1 = (int) Math.ceil(numOfQuestions / 5);
        int repeat2 = (int) Math.ceil(numOfQuestions / 8);
        int repeat3 = (int) Math.ceil(numOfQuestions / 10);
        int[] repeats = new int[]{repeat1, repeat2, repeat3};

        String[][] studentAnswers = new String[3][];


        for (int i = 0; i < 3; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < repeats[i]; j++) {
                sb.append(students[i]);
            }

            studentAnswers[i] = sb.toString().split(",");
        }

        // 학생1~3의 답안지를 정답과 비교해서 채점/확인 -> '학생 번호 - 점수' 세트로 map에 넣음
        int[] numOfCorrectAnswers = new int[3];
        Map<Integer, Integer> studentAndCorrectAnswers = new HashMap<>();
        int sizeOfAnswerArray = 0;

        for (int i = 0; i < 3; i++) {
            String[] studentAnswer = studentAnswers[i];

            for (int j = 0; j < answers.length; j++) {
                if (String.valueOf(answers[j]).equals(studentAnswer[j])) {
                    numOfCorrectAnswers[i]++;
                }
            }

            if (numOfCorrectAnswers[i] > 0) sizeOfAnswerArray++;

            System.out.println(i + 1 + "번 학생은 " + numOfCorrectAnswers[i] + "개 문제를 맞았습니다");
            studentAndCorrectAnswers.put(i + 1, numOfCorrectAnswers[i]);
        }

        /* 각 학생의 점수가 0보다 큰 경우
        점수가 높은 순서대로 정렬해서 학생 번호를 반환할 배열에 담음
         */
        int[] answer = new int[sizeOfAnswerArray];

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }
}
