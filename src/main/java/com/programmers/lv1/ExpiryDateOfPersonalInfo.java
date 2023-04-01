package com.programmers.lv1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.*;

// 2023.3.26(일) 23h20 2023 kakao blind recruitment 기출 문제인데, 나도 작년인가 응시해서 본 적 있는 문제임
// ~ 23h50 일단 입력 자료들을 LocalDateTime 및 map으로 만드는 것까지 함
/* 2023.4.1(토) 22h10 ~ 22h50 v1 작성
- 문제에서는 1달을 28일로 가정하는데, 나는 그걸 따로 안 만지고 그냥 Java time 라이브러리 사용했더니, expiryDate가 정확히 계산이 안 됨 + today와 비교가 정확하지 않음? -> 입/출력 예시 2개는 꾸역꾸역 맞췄는데, 제출 시 30.0
- import java.time.*로 import문 썼더니 아래 오류 -> 인텔리제이에서 라이브러리 불러와진대로 제출했더니, 아래 오류는 해결 cf. 프로그래머스 컴파일러 = Java 14
/Solution.java:10: error: cannot find symbol
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
        ^
  symbol:   class DateTimeFormatter
  location: class Solution
/Solution.java:14: error: cannot find symbol
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                                 ^
  symbol:   variable ChronoField
  location: class Solution
/Solution.java:13: error: cannot find symbol
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                                 ^
  symbol:   variable ChronoField
  location: class Solution
/Solution.java:12: error: cannot find symbol
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                                 ^
  symbol:   variable ChronoField
  location: class Solution
/Solution.java:10: error: cannot find symbol
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                                          ^
  symbol:   class DateTimeFormatterBuilder
  location: class Solution
 */
public class ExpiryDateOfPersonalInfo {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd"); // https://hianna.tistory.com/609 -> 23h40 Unable to obtain LocalDateTime from TemporalAccessor
        // https://kdevkr.github.io/java-datetime-format/ 참고
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("[yyyy.MM.dd]")
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .toFormatter();
        LocalDateTime todayLdt = LocalDateTime.parse(today, formatter);
        System.out.println("오늘 날짜 = " + todayLdt); // todo

        Map<String, Integer> termsMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] split = terms[i].split(" ");
            termsMap.put(split[0], Integer.parseInt(split[1]));
        }
        System.out.println("terms = " + termsMap); // todo

        Map<LocalDateTime, String> privaciesMap = new HashMap<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");

            LocalDateTime date = LocalDateTime.parse(split[0], formatter);
            String info = split[1] + (i + 1);

            privaciesMap.put(date, info);
        }
        System.out.println("privacies = " + privaciesMap); // todo

        //List<LocalDateTime> expiryDates = new ArrayList<>();

        Set set = privaciesMap.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            String term = String.valueOf(((String) e.getValue()).charAt(0));

            Integer months = termsMap.get(term);

            LocalDateTime expiryDate = ((LocalDateTime) e.getKey()).plusMonths(months);
            //expiryDates.add(expiryDate);
            System.out.println("개인정보 유효기간 = " + expiryDate);

            Integer idx = Character.getNumericValue(((String) e.getValue()).charAt(1));

            if (expiryDate.isBefore(todayLdt)) {
                answer.add(idx);
            }

            if (expiryDate.isEqual(todayLdt)) {
                answer.add(idx);
            }
        }
        /*
        System.out.println("expiryDates = " + expiryDates); // todo

        for (int i = 0; i < expiryDates.size(); i++) {
            LocalDateTime ldt = expiryDates.get(i);

            if (ldt.isAfter(todayLdt)) {
                answer.add(i + 1);
            }
        }
         */

        int[] answerArray = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerArray[i] = answer.get(i);
        }

        Arrays.sort(answerArray);

        return answerArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
        System.out.println(Arrays.toString(solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"})));
    }
}
