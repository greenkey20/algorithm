package com.programmers.lv0;

public class Babbling1 {
    // 2022.11.12(토) 23h50 v1 = 문제에서 의도한 바를 구현하지 못했으므로, 실패
    public static int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            // v1 = "aya", "ye", "woo", "ma" 4가지 발음을 포함하고 있더라도, 이 4개 발음 외에 다른 string을 가지고 있다면 그건 발음할 수 있는 단어가 아님
            // if (babbling[i].contains("aya") || babbling[i].contains("ye") || babbling[i].contains("woo") || babbling[i].contains("ma")) answer++;

            // 2022.11.13(일) 1h15 v2
            String toCheck = babbling[i];
            String replaced = toCheck.replace("aya", "").replace("ye", "").replace("woo", "").replace("ma", "");
            System.out.println(replaced);

            if (replaced.length() == 0) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"})); // 1 vs v2 실행 결과는 2 <- "wyeoo"가 발음 가능한 단어로 판별됨
        System.out.println(solution(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"})); // 3
    }
}
