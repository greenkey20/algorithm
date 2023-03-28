package com.programmers.lv1;

import java.util.Arrays;

// 2023.3.28(화) 22h45 ~ 23h45 v1 = 테스트 6 및 7 통과 못함
public class DartGame {
    public static int solution(String dartResult) {
        int answer = 0;

        int[] scores = new int[3];
        int time = 0;
        int i = 0;

        while (time < 3) {
            char numChar = dartResult.charAt(i);
            int numInt = Character.getNumericValue(numChar);
            char area;

            if (numInt == 1 && dartResult.charAt(i + 1) == '0') {
                numInt = 10;
                area = dartResult.charAt(i + 2);
            } else {
                area = dartResult.charAt(i + 1);
            }

            int exponent;

            if (area == 'S') {
                exponent = 1;
            } else if (area == 'D') {
                exponent = 2;
            } else {
                exponent = 3;
            }

            int score = (int) Math.pow(numInt, exponent);

            char next;

            if (time != 2) {
                if (numInt != 10) {
                    next = dartResult.charAt(i + 2);
                } else {
                    next = dartResult.charAt(i + 3);
                }

                if (!Character.isDigit(next)) {
                    if (next == '*') {
                        if (time != 0) {
                            score *= 2;
                            scores[time - 1] *= 2;
                        } else {
                            score *= 2;
                        }
                    } else { // if (next == '#')
                        score *= -1;
                    }

                    if (numInt != 10) {
                        i += 3;
                    } else {
                        i += 4;
                    }
                } else {
                    if (numInt != 10) {
                        i += 2;
                    } else {
                        i += 3;
                    }
                }
            }

            scores[time] = score;
            System.out.println(time + 1 + "번째 다트에서 scores 배열 = " + Arrays.toString(scores)); // todo

            time++;
        }

        for (int j = 0; j < scores.length; j++) {
            answer += scores[j];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T")); // 37
        System.out.println(solution("1D2S#10S*")); // 9
        System.out.println(solution("1S*2T*3S")); // 23
        System.out.println(solution("1D#2S*3S")); // 5
        System.out.println(solution("1T2D3D#")); // -4 = 테스트6 vs 나의 v1은 14
        System.out.println(solution("1D2S3T*")); // 59 = 테스트7 vs 나의 v1은 30
    }
}
