package com.programmers.lv1;

// 2023.3.31(금) 22h50 ~ 22h55 입출력 예시로는 의도한대로 동작하는데, 제출 시 런타임 에러 + 정확성 63.2
/* 다른 분의 질문하기 = p의 크기가 long을 사용할 만큼 크지 않은데, 왜 long을 써야 하는지 알고계신분 있으신가요?
답변1 = 제한사항을 보면 숫자의 범위가 아닌 문자열의 길이가 10,000까지이기 때문에 t는 long타입으로 해야 하고, p의 최대 길이가 t의 길이이기 때문에 p도 int 타입 범위를 넘어갈 수 있습니다
 */
public class SmallerSubstring {
    public static int solution(String t, String p) {
        int answer = 0;

        int lengthOfP = p.length();
        int numP = Integer.valueOf(p);

        for (int i = 0; i <= t.length() - lengthOfP; i++) {
            int substringT = Integer.valueOf(t.substring(i, i + lengthOfP));

            if (substringT <= numP) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("3141592", "271")); // 2
        System.out.println(solution("500220839878", "7")); // 8
    }
}
