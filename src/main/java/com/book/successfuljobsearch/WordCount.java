package com.book.successfuljobsearch;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// 2023.8.26(토) 23h50
public class WordCount {
    public static void main(String[] args) {

    }

    /**
     * 문제: 많이 사용된 단어 확인을 위해 단어 추출 프로그램을 만들었다.
     * 단어 목록을 받으면 각 단어별로 개수를 화면에 출력하는 프로그램을 만드시오.
     *
     * 2023.8.27(일) 13h55 조건 추가 = 출력되는 단어는 가나다 순으로 정렬되어야만 한다
     *
     * 입출력 예시1)
     * 입력) [과목, 수첩, 연필, 과목, 시험]
     * 출력)
     * 과목:2
     * 수첩:1
     * 시험:1
     * 연필:1
     *
     * @param words
     * @return
     */
    public static String countWords(String[] words) {
        // null이 입력된 경우
        try {
            if (words == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception이 발생했습니다");
        }

        // 빈 배열이 입력된 경우
        if (words.length == 0) {
            return "빈 배열이 입력되었습니다";
        }

        StringBuffer sb = new StringBuffer();

        // 각 단어와 사용 횟수를 각각 key:value로 저장할 map을 만든다
        Map<String, Integer> wordAndCountMap = new TreeMap<>();
        // 추가 조건 구현을 위해 TreeMap 사용 이외에 Stream으로도 작성해보자 <- reference = https://howtodoinjava.com/java/sort/java-sort-map-by-key/

        // 입력으로 주어진 배열의 원소(단어)들을 하나하나 순회하면서
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // 2023.8.27(일) 10h35 나의 생각 = 빈 문자열("")이 원소로 들어온 경우는 어떻게 처리하는 것이 좋을까?
            if (!word.equals("")) {
                // 해당 단어가 map에 key로 존재하지 않으면, 해당 단어를 key로, 1을 value로 하여 map에 추가한다
                if (!wordAndCountMap.containsKey(word)) {
                    wordAndCountMap.put(word, 1);
                } else { // 해당 단어가 map에 key로 존재하면, 해당 key에 해당하는 value의 값을 1 증가시킨다
                    int value = wordAndCountMap.get(word);
                    wordAndCountMap.put(word, value + 1);
                }
            }
        }

        Set set = wordAndCountMap.entrySet();
        Iterator it = set.iterator();
        // map의 요소를 하나하나 순회하면서
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();

            // 'key:value' 형식으로 sb에 append()
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append("\n");
        }

        return sb.toString();
    }
}
