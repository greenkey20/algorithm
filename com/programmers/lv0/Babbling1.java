package com.programmers.lv0;

import java.util.Arrays;

public class Babbling1 {
    // 2022.11.12(토) 23h50 v1 = 문제에서 의도한 바를 구현하지 못했으므로, 실패
    public static int solution(String[] babbling) {
        int answer = 0;

        String[] replacedWords = new String[babbling.length];
        for (int i = 0; i < babbling.length; i++) {
            // v1 = "aya", "ye", "woo", "ma" 4가지 발음을 포함하고 있더라도, 이 4개 발음 외에 다른 string을 가지고 있다면 그건 발음할 수 있는 단어가 아님
            // if (babbling[i].contains("aya") || babbling[i].contains("ye") || babbling[i].contains("woo") || babbling[i].contains("ma")) answer++;

            // 2022.11.13(일) 1h15 v2
            String toCheck = babbling[i];
            String replaced = toCheck.replace("aya", "/").replace("ye", "/").replace("woo", "/").replace("ma", "/");
//            System.out.println(replaced);
//            if (replaced.length() == 0) answer++;
            replacedWords[i] = replaced;
        }

//        System.out.println(Arrays.toString(replacedWords));
        /* 테스트케이스1 = [/, /e, u, /a, w/oo]
        테스트케이스2 = [//, uuu/, /, ///, /a]
         */


        // 2022.11.13(일) 1h30 v3 -> 1h50 통과
        for (int i = 0; i < replacedWords.length; i++) {
            String toCheck = replacedWords[i];
            // googling '자바 문자열이 알파벳인지' -> 'Java에서 문자열에 알파벳만 포함되어 있는지 확인'(https://www.techiedelight.com/ko/check-string-contains-only-alphabets-java/)
            // if (!toCheck.chars().anyMatch(Character::isLetter)) answer++; // 처음에 allMatch 연산(모든 요소들이 매개값으로 주어진 predicate의 조건을 만족하는지 조사)했는데, 잘 생각해보면 내가 원하는 결과를 줄 수 없음
            if (!toCheck.chars().anyMatch(ch -> Character.isLetter(ch))) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"})); // 1 vs v2 실행 결과는 2 <- "wyeoo"가 발음 가능한 단어로 판별됨
        System.out.println(solution(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"})); // 3
    }
}
