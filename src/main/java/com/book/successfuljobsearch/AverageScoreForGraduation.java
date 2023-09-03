package com.book.successfuljobsearch;

// 2023.8.14(월) 12h35
//@Slf4j
public class AverageScoreForGraduation {
    public static void main(String[] args) {

    }

    /**
     * 문제: 100점 만점의 시험을 보고 있다. 평균 90점 이상 되면 졸업이 가능하다.
     * 앞으로의 시험을 모두 100점 맞는다고 가정했을 때, 앞으로 얼마나 많은 시험을 봐야 졸업이 가능한지
     * 그 횟수를 리턴하는 메서드를 만드시오.
     *
     * 가정:
     * 1. null이 입력으로 들어오는 경우
     * 2. 빈 배열이 입력으로 들어오는 경우
     *
     * @param scores
     * @return
     */
    public static int getNumOfExamsForGraduation(int[] scores) {
        // 1. 현재 scores의 평균을 구한다
        // 2. 1에서 구한 평균이 90점 미만이라면 while문을 돌면서 scores의 합계에 100을 더해간다
        // 3. 위 [합계 / (scores 배열의 원소의 갯수 + 100점 추가 개수)] 값이 90점 이상이 되면 while문을 탈출한다
        // 4. '100점 추가 갯수'를 반환한다

        try {
            if (scores == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
//            log.info();
            System.out.println("Null Pointer Exception이 발생했습니다");

        }

        if (scores.length == 0) {
            return 1;
        }

        int result = 0;
        int sum = 0;
        double average = 0;

        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];

            try {
                if (score < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal Argument Exception이 발생했습니다");
            }

            sum += scores[i];
        }

        average = Math.round(sum / (double) scores.length);

        while (average < 90) {
            sum += 100;
            result++;
            average = Math.round(sum / ((double) scores.length + result));
        }

        return result;
    }
}
