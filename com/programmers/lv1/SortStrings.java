package com.programmers.lv1;

import java.util.*;
import java.util.stream.Collectors;

// 2022.11.27(일) 0h50
public class SortStrings {
    public String[] solution(String[] strings, int n) {
        /*
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("o1 = " + o1 + ", o2 = " + o2);
                char c1 = o1.charAt(n);
                char c2 = o2.charAt(n);
                System.out.println("c1 = " + c1 + ", c2 = " + c2 + ", c1 < c2 = " + (c1 < c2));

                if (c1 < c2) return -1; // 2022.11.27(일) 23h50 제출 시 입/출력 예시는 통과하나, 테스트케이스1만 통과 + 테스트케이스2~12 실패
                else if (c1 == c2) return o1.compareTo(o2);
                else return o1.compareTo(o2);
            }
        });
         */

        // 2022.11.27(일) 23h50 v3 Arrays.sort() 오버라이딩 말고, 로직 한 줄 한 줄 구현해보자 -> 2022.11.28(월) 0h20 제출/테스트해 보니, 중복 값이 list에 담길 수 있음(입/출력예시1 ["car","bed","car","sun"], 2 ["abcd","abce","abce","cdx"])을 내가 충분히 고민하지 않았음을 알게 됨
        // '질문하기' 잠깐 훑어보고 얻은 아이디어 = strings 배열을 sort한 다음, n번째 글자 비교해서 정렬 수정
        Arrays.sort(strings); // strings 배열의 원소들을 오름차순으로 정렬해둠
//        String[] answer = new String[strings.length];

        /*
        List<String> answerList = new ArrayList<>();

        for (int i = 0; i < strings.length - 1; i++) {
            String o1 = strings[i];
            String o2 = strings[i + 1];

            char c1 = o1.charAt(n);
            char c2 = o2.charAt(n);

            if (c1 > c2) {
                answerList.add(o2);
                answerList.add(o1);
            } else {
                answerList.add(o1);
                answerList.add(o2);
            }
        }

        return answerList.toArray(new String[strings.length]);
         */

        // 2022.11.28(월) 0h35 v4 아이디어 다시 정리해서 다시 코딩
        // map 하나 만들어서 오름차순 순서(key)-strings[i] 원소의 n번째 글자(value)를 담아둠
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

    public static void main(String[] args) {
        String[] output = new SortStrings().solution(new String[]{"sun", "bed", "car"}, 1);
        System.out.println(Arrays.toString(output)); // ["car", "bed", "sun"] vs 1h10 v1 및 v2 실행 결과 = [bed, car, sun] -> 2022.11.27(일) 23h20 debugging 해보고, 로그 찍어보지만, 내가 쓴 오버라이딩한 sort() 동작 원리 잘 모르겠음

        output = new SortStrings().solution(new String[]{"abce", "abcd", "cdx"}, 2);
        System.out.println(Arrays.toString(output)); // [abcd, abce, cdx]
    }
}
