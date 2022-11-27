package 프로그래머스.lv1.q12915;

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);

        Map<Integer, Character> nMap = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            nMap.put(i, strings[i].charAt(n));
//            System.out.println(nMap);
        }

        // map의 key-value 쌍을 list로 만듦 -> value 값의 오름차순으로 정렬
        // google "자바 map 정렬" -> https://ponyozzang.tistory.com/404 문법 및 코드 참고
        List<Map.Entry<Integer, Character>> listEntries = new ArrayList<>(nMap.entrySet());
//        System.out.println(listEntries); // [0=e, 1=a, 2=u]

        Collections.sort(listEntries, new Comparator<Map.Entry<Integer, Character>>() {
            @Override
            public int compare(Map.Entry<Integer, Character> o1, Map.Entry<Integer, Character> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
//        System.out.println(listEntries); // [1=a, 0=e, 2=u]

        // 이 메서드의 반환 자료(String 배열) 변수 하나 만듦
        String[] answer = new String[strings.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = strings[listEntries.get(i).getKey()]; // n번째 글자의 오름차순으로 정렬된 listEntries의 key 값 = strings 배열에서의 위치/인덱스 -> listEntries가 정렬된 순서대로 strings 배열에서 단어 꺼내서 answer 정렬에 담음
        }

        return answer;
    }
}