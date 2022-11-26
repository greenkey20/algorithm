package com.programmers.lv1;

import java.util.Arrays;
import java.util.Comparator;

// 2022.11.27(일) 0h50
public class SortStrings {
    public String[] solution(String[] strings, int n) {
//        String[] answer = new String[strings.length];

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char c1 = o1.charAt(n);
                char c2 = o2.charAt(n);

                if (c1 > c2) return o1.compareTo(o2);
                else if (c1 == c2) return o1.compareTo(o2);
                else return o1.compareTo(o2);
            }
        });

        return strings;
    }

    public static void main(String[] args) {
        String[] output = new SortStrings().solution(new String[]{"sun", "bed", "car"}, 1);
        System.out.println(Arrays.toString(output)); // ["car", "bed", "sun"] vs 1h10 실행 결과 = [bed, car, sun]

        output = new SortStrings().solution(new String[]{"abce", "abcd", "cdx"}, 2);
        System.out.println(Arrays.toString(output)); // [abcd, abce, cdx]
    }
}
