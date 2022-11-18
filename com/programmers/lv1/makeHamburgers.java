package com.programmers.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class makeHamburgers {
    // 2022.11.17(목) 2h25
    public int solutionDraft1(int[] ingredients) {
        int answer = 0;

        /* stack을 하나 만들어 재료들을 쌓아두자
        ingredients[i] 요소가 1인 경우 -> stack.size(0)인 경우 ou stack.size(3)인 경우 stack에 마지막 빵 추가
        */

        // 2022.11.18(금) 8h30 계속해서 풀이/시도 -> 8h45 stack 어떻게 무엇을 쌓을지 고민하다가, 나 스스로는 풀기 어려울 것 같아 googling
        List<Stack<Integer>> hamburgers = new ArrayList<>();
        int breadCnt = 0;

        // ingredients 배열의 원소들을 하나하나 순회하면서
        for (int i = 0; i < ingredients.length; i++) {
            int ingredient = ingredients[i];
            Stack<Integer> hamburger = new Stack<>();

            if (ingredient == 1) {
                breadCnt++;
            }

            // 현재까지 빵이 짝수 개 나왔다면 = 다른 햄버거들은 완성되었다 -> 새로운 햄버거를 만든다 -> 2022.11.18(금) 9h50 나의 생각 = 이렇지 않은 경우들도 있으므로 이 로직은 맞지 않음
            if (breadCnt % 2 == 0) {
                hamburger.push(ingredient);
                hamburgers.add(hamburger);
            } else {

            }

        }

        return answer;
    }

    // 구글링 https://yongku.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%96%84%EB%B2%84%EA%B1%B0-%EB%A7%8C%EB%93%A4%EA%B8%B0-%EC%9E%90%EB%B0%94JAVA + 문제 질문/토론 글 https://school.programmers.co.kr/questions/39179
    public int solutionReference(int[] ingredients) {
        int answer = 0;

        return answer;
    }

    // 2022.11.18(금) 10h20 나의 시도2 = 햄버거를 String으로 만들어가는 방법
    /* 참고 https://school.programmers.co.kr/questions/38823 = 효율성은 스트링과 스트링빌더의 구분을 할 수 있는지 + 스트링의 replacefirst를 스트링빌더로 동작할 수 있는지가 관건
    vs 10h30 제출 시 9개(/총 18개) 테스트케이스 시간 초과로 실패 -> 정확히 어느 코드가 효율성을 저하시키는지 정확히 모르겠지만(나의 질문 = 어떻게 알 수 있을까?) 위 참고 글 코드와 비교/대조해서 조금 수정해봄 -> 11h 통과
     */
    public int solutionDraft2(int[] ingredients) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ingredients.length; i++) {
            sb.append(ingredients[i]);

            if (sb.length() >= 4 && sb.substring(sb.length() - 4, sb.length()).equals("1231")) {
                answer++;
                sb.delete(sb.length() - 4, sb.length());

                /* string 햄버거 v1
                int hamburgerIndex = sb.indexOf("1231");
                if (hamburgerIndex >= 0) {
                    answer++;
                    sb.delete(hamburgerIndex, hamburgerIndex + 4);
                }
                 */
            }
        }

        return answer;
    }
}
