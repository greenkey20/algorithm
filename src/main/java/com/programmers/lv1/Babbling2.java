package com.programmers.lv1;

public class Babbling2 {
    // 2023.2.18(토) 17h45 -> 18h v1 의도하는대로 작동x
    // "aya", "ye", "woo", "ma" 4가지 발음 + 이 4가지 발음의 조합 + 연속해서 같은 발음은 못함
    public static int solution(String[] babbling) {
        int answer = 0;

        String[] replacedBabbling = new String[babbling.length];

        for (int i = 0; i < babbling.length; i++) {
            String toCheck = babbling[i];
            String replaced = toCheck.replace("aya", "1")
                    .replace("ye", "2")
                    .replace("woo", "3")
                    .replace("ma", "4");

            replacedBabbling[i] = replaced;
        }

        for (int i = 0; i < replacedBabbling.length; i++) {
            String toCheck = replacedBabbling[i];
            for (int j = 0; j < toCheck.length() - 1; j++) {
                char ch = toCheck.charAt(j);
                if (Character.isDigit(ch) && ch != toCheck.charAt(j + 1)) {
                    answer++;
                    System.out.println(toCheck + "의 " + j + "번째 글자 = " + ch); // todo
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"aya", "yee", "u", "maa"})); // 1
        System.out.println(solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"})); // 2
    }
}
