package com.programmers.lv1;

import java.util.Arrays;
import java.util.Comparator;

// 2022.11.27(일) 0h50
public class SortStrings {
    public String[] solution(String[] strings, int n) {
//        String[] answer = new String[strings.length];

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

        // 2022.11.27(일) 23h50 Arrays.sort() 오버라이딩 말고, 로직 한 줄 한 줄 구현해보자
        // '질문하기' 잠깐 훑어보고 얻은 아이디어 = strings 배열을 sort한 다음, n번째 글자 비교해서 정렬 수정
        Arrays.sort(strings);

        return strings;
    }

    public static void main(String[] args) {
        String[] output = new SortStrings().solution(new String[]{"sun", "bed", "car"}, 1);
        System.out.println(Arrays.toString(output)); // ["car", "bed", "sun"] vs 1h10 v1 및 v2 실행 결과 = [bed, car, sun] -> 2022.11.27(일) 23h20 debugging 해보고, 로그 찍어보지만, 내가 쓴 오버라이딩한 sort() 동작 원리 잘 모르겠음

        output = new SortStrings().solution(new String[]{"abce", "abcd", "cdx"}, 2);
        System.out.println(Arrays.toString(output)); // [abcd, abce, cdx]
    }
}
