package com.programmers.lv1;

import java.util.Arrays;

public class Babbling2 {
    // 2023.2.18(토) 17h45 ~ 18h v1 의도하는대로 작동x -> 18h20 v2도 의도하는대로 동작x -> 18h40 v3도 의도하는대로 동작x
    // "aya", "ye", "woo", "ma" 4가지 발음 + 이 4가지 발음의 조합 + 연속해서 같은 발음은 못함
    public static int solution(String[] babbling) {
        int answer = 0;

        String[] replacedBabbling = new String[babbling.length];

        for (int i = 0; i < babbling.length; i++) {
            String toCheck = babbling[i];
            String replaced = toCheck.replace("aya", "!")
                    .replace("ye", "@")
                    .replace("woo", "#")
                    .replace("ma", "^");

            replacedBabbling[i] = replaced;
        }
        System.out.println(Arrays.toString(replacedBabbling)); // todo

        for (int i = 0; i < replacedBabbling.length; i++) {
            String toCheck = replacedBabbling[i];
            for (int j = 0; j < toCheck.length() - 1; j++) {
                char chLeft = toCheck.charAt(j);
                char chRight = toCheck.charAt(j + 1);
                System.out.println("toCheck = " + toCheck + ", chLeft = " + chLeft + ", chRight = " + chRight); // todo

                if (!Character.isLetter(chLeft)) { // 현재 검사 중인 글자가 특수문자이면
                    if (j == toCheck.length() - 1) { // 현재 검사 중인 단어가 숫자 1개로 이루어져 있다면, 또는 이 내부for문에서 이 j 조건까지 왔다면(=현재 검사 중인 단어의 마지막 단어라면) = 이 단어는 발음할 수 있음
                        answer++;
                        System.out.println(toCheck + "의 " + (j + 1) + "번째 글자 = " + chLeft + ", answer = " + answer); // todo
                        break; // 이 단어의 다음 음절/글자들 확인할 필요 없이, 다음 단어 검사로 넘어감
                    } else { // 현재 검사 중인 단어가 숫자 1개 이외 다른 글자도 가지고 있다면
                        if (!Character.isLetter(chRight) && chLeft != chRight) { // 다음 글자도 특수문자이고, 현재 글자와 다음 글자가 다르다면
                            continue;
                        } else { // 다음 글자가 숫자가 아니거나, 현재 글자와 다음 글자가 같다면 = 이 단어는 발음할 수 없음 -> 다음 단어 검사로 넘어감
                            break;
                        }
                    }
                } else { // 현재 검사 중인 글자가 특수문자가 아니면/알파벳이면 = 이 단어는 발음할 수 없음 -> 다음 단어 검사로 넘어감
                    break;
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
