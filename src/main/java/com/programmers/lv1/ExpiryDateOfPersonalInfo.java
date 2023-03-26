package com.programmers.lv1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.*;

// 2023.3.26(일) 23h20 2023 kakao blind recruitment 기출 문제인데, 나도 작년인가 응시해서 본 적 있는 문제임
// ~ 23h50 일단 입력 자료들을 LocalDateTime 및 map으로 만드는 것까지 함
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
        System.out.println(todayLdt); // todo

        Map<String, Integer> termsMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] split = terms[i].split(" ");
            termsMap.put(split[0], Integer.parseInt(split[1]));
        }
        System.out.println(termsMap); // todo

        Map<LocalDateTime, String> privaciesMap = new HashMap<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");

            LocalDateTime date = LocalDateTime.parse(split[0], formatter);

            privaciesMap.put(date, split[1]);
        }
        System.out.println(privaciesMap); // todo

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
