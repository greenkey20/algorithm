package com.programmers.lv1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Year2016 {
    // 2022.11.16(수) 0h10
    public String solution1(int a, int b) {
        String answer = "";

        // google '자바 요일 구하기' 검색해서 국문 블로그 글 하나(https://hianna.tistory.com/610) skimming + Java 정석 참고
        // 단계1) LocalDate 생성
        LocalDate date = LocalDate.of(2016, a, b);

        // 단계2) DayOfWeek(요일) 객체 구하기
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        // 단계3) 단계2에서 구한 요일을 텍스트 요일로 바꾸기
        answer = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US).toString().toUpperCase();

        return answer;
    }

    /* 회고
    1. 다른 분들의 답안을 보니, 달력/요일 구하기 알고리즘을 생각해 봐야 한다 vs 나는 너무 게으른 방식으로 풀었다 ㅠㅠ
     */
    // 2022.11.16(수) 1h 제출 시 대표 테스트 케이스 1개 통과 못함 -> 3월 2일에 대해 나의 알고리즘을 적용해보니, 현재는 1월 날짜 수는 안 더하고, 2월의 날짜 수만 더해서 nThDay 구하고 있음 -> daysInMonth[0] + daysInMonth[1] + ... + daysInMonth[a - 2] 해야 함
    public String solution2(int a, int b) {
        String answer = "";

        // a월 b일이 2016년의 몇 번째 날(nThDay)인지 계산(종이에 일반화 식 및 예시 써서 생각, 검증..) -> 그 숫자를 7로 나눈 나머지에 따라 7개의 요일 부여/매칭
        // 각 월이 몇 개의 날을 가지고 있는지 정보 필요 -> (a - 1)월의 날짜 개수가 꼭 필요함 -> 배열의 인덱스와 연관지어 사용 가능
        int[] daysInMonth = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int nThDay = 0;

        /*
        if (a > 1) {
            nThDay = (a - 1) * daysInMonth[a - 2] + b;
        } else {
            nThDay = b;
        }
         */
        nThDay = a > 1 ? (a - 1) * daysInMonth[a - 2] + b : b;

        String[] daysOfWeek = new String[]{"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        answer = daysOfWeek[nThDay % 7];
        return answer;
    }

}
