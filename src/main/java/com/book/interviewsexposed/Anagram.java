package com.book.interviewsexposed;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// 2023.9.26(화) 14h5
public class Anagram {

    /**
     * Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 애너그램이라고 한다.
     * 주어진 단어의 목록에서 특정 단어에 대한 전체 애너그램 목록을 반환하는 알고리즘을 작성하라.
     *
     * @param words
     * @param word
     * @return
     */
    public static List<String> getAnagrams(List<String> words, String word) {
        // 주어진 단어 word에 출현하는 글자 및 각 글자의 출현 횟수를 map에 key-value 쌍으로 담음
        Map<Character, Integer> wordCharactersMap = new TreeMap<>();

        for (int i = 0; i < word.length(); i++) {
            Character thisCh = word.charAt(i);

            if (!wordCharactersMap.containsKey(thisCh)) {
                wordCharactersMap.put(thisCh, 1);
            } else {
                int value = wordCharactersMap.get(thisCh);
                wordCharactersMap.put(thisCh, value + 1);
            }
        }

        List<String> anagrams = new ArrayList<>();

        for (String str : words) {
            // str에 출현하는 글자 및 각 글자의 출현 횟수를 map에 key-value 쌍으로 담음 -> charactersMap의 내용물과 비교
            Map<Character, Integer> strCharactersMap = new TreeMap<>();

            for (int i = 0; i < str.length(); i++) {
                Character thisCh = str.charAt(i);

                if (!strCharactersMap.containsKey(thisCh)) {
                    strCharactersMap.put(thisCh, 1);
                } else {
                    int value = strCharactersMap.get(thisCh);
                    strCharactersMap.put(thisCh, value + 1);
                }
            }


            // 여기까지 왔으면 str은 word의 애너그램이므로, anagrams 리스트에 str을 원소로 추가
            anagrams.add(str);
        }

        return anagrams;
    }
}
