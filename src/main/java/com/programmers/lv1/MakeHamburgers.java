package com.programmers.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MakeHamburgers {
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
    public int solutionReference1(int[] ingredients) {
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

    /* 회고
    1. 문제의 추상화를 조금 더 신중하게, 천천히, 급하지 않게, 했었어야 했다
    stack 자료구조를 쓰든, String으로 풀든, 문제에서 요구하는 바, 그리고 그것을 달성하기 위한 방법을 더 정확하고 면밀하게 검토하고 정리했어야 한다
    2. 내가 문제에 처음 접근할 때는 꼭 입/출력 예시1 ingredients 배열의 첫번째 빵에 재료들을 쌓아나가야겠다고 (편협하게/잘못)생각했었다
    vs 다시 생각하면 (적어도 이 문제에서는) 처음 나오는 빵이든, 나중에 나오는 빵이든, 나오는 순서와 사용하는 순서는 상관이 없으며, 현재까지 다른 풀이 방법들을 보면 앞에 나온 빵에 재료들을 쌓을 수 없으면 그냥 내버려두고 다음 재료로 넘어간다
    3. stack의 개념은 Stack, ArrayList와 같은 collection framework 뿐만 아니라 배열, 문자열 등 자료를 차곡차곡 쌓을 수 있는 방법이라면 여러 가지 방식으로 구현이 가능하다 -> 문제 처음 접근/검토 시에는 너무 특정 자료구조에 매몰되지 말고, 문제의 본질 파악 및 정확한 추상화에 집중해보자
     */

    // 11h45 나의 생각 = 와, reference2/3과 같이 스택에 재료 쌓으며, 햄버거 여부 확인하고, 스택으로부터 햄버거는 치워서 남은 재료들로 다시 쌓고.. 큰 접근 방식은 동일한 것 같은데, 구현이 훨씬 어려워 보이는 것은 왜일까? 이런 접근 방법을 구상/구현할 수 있으려면 현재 나는 어떤 부분을 훈련해야 할까? 일단 아래와 같은 코드의 동작을 이해는 했으니, 내가 직접 (다음 며칠 이내로)짜보자
    // 요오게, ksb0903, 뿌찌뿌찌, 손지희, withthdud0923@gmail.com 외 2 명
    public int solutionReference2(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;
        for (int i : ingredient) {
            stack[sp++] = i; // 11h40 나의 질문 = stack[i]에 i번째 재료를 넣고, 그 다음에 sp를 1 증가시켜 나간다고 이해하면 맞나?
            if (sp >= 4 && stack[sp - 1] == 1
                    && stack[sp - 2] == 3
                    && stack[sp - 3] == 2
                    && stack[sp - 4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        return answer;
    }

    // 크캬캬캬님 -> 11h25 동작 원리 아직 정확히 이해 안 됨 -> 11h35 입/출력 예시1로 동작 종이에 써서 이해함
    // 나의 질문 = 2중 for문인데도 시간 초과 없이 통과할 수 있는 이유/원리는 무엇일까?
    public int solutionReference3(int[] ingredient) {
        int answer = 0;
        for (int i = 0; i < ingredient.length - 3; i++) {
            if (ingredient[i] == 0) continue;
            if (ingredient[i] == 1 && ingredient[i + 1] == 2 && ingredient[i + 2] == 3 && ingredient[i + 3] == 1) {
                for (int j = i + 3; j > 0; j--) {
                    ingredient[j] = (j > 3) ? ingredient[j - 4] : 0; // 햄버거 아직 안 만들어진 재료들을 뒤로 옮기고, 이미 햄버거로 만든 재료들은 0으로 바꿈
                }
                answer++;
            }
        }
        return answer;
    }
}
