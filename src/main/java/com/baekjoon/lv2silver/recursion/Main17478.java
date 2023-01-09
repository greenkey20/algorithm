package com.baekjoon.lv2silver.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2023.1.10(화) 6h20 -> 7h10 실행 시 stack overflow error 발생
public class Main17478 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 출력을 원하는 재귀 회수

        // 문제 해결 로직
        StringBuilder sbResult = new StringBuilder();
        sbResult.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n")
                .append("\"재귀함수가 뭔가요?\"\n")
                .append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n")
                .append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n")
                .append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

        printRecursiveAnswers(n, 1);

        // 출력
    }

    /* 출력해야 하는 내용의 구조
    e.g. n = 4
    기본 문답 = 어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다. "재귀함수가 뭔가요?"
              "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어. 마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지. 그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어. ["재귀함수가 뭔가요?"
    답변 속의 답변1 = "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.. "재귀함수가 뭔가요?"
    답변 속의 답변2 = "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.. "재귀함수가 뭔가요?"
    답변 속의 답변3 = "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.. "재귀함수가 뭔가요?"
    답변 속의 답변4 = "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.. "재귀함수가 뭔가요?"


    답변 속의 답변4 = ________________"재귀함수는 자기 자신을 호출하는 함수라네"
                  ________________라고 답변하였지. (underbar 개수 = 4*4)
    답변 속의 답변3 = ____________라고 답변하였지. (underbar 개수 = 4*3)
    답변 속의 답변2 = ________라고 답변하였지. (underbar 개수 = 4*2)
    답변 속의 답변1 = ____라고 답변하였지. (underbar 개수 = 4*1)
    기본 답변 = 라고 답변하였지.

    e.g. n = 2
    기본 문답 =
        어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다. "재귀함수가 뭔가요?"
        "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어. 마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지. 그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.

    답변 속의 문답1 =
        ____"재귀함수가 뭔가요?"
        ____"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
        ____마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
        ____그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."

    답변 속의 문답2 =
        ________"재귀함수가 뭔가요?"
        ________"재귀함수는 자기 자신을 호출하는 함수라네"
        ________라고 답변하였지.

    답변 속의 문답1 =
        ____라고 답변하였지.

    기본 답변 =
        라고 답변하였지.

    e.g. n = 1
    어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.
    "재귀함수가 뭔가요?"
    "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
    마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
    그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
    ____"재귀함수가 뭔가요?"
    ____"재귀함수는 자기 자신을 호출하는 함수라네"
    ____라고 답변하였지.
    라고 답변하였지.

    문제를 더 이상 쪼갤 수 없을 때 = depth가 n과 같아졌을 때 = 'depth == n'
    depth * 4개의 underbar + "재귀함수가 뭔가요?"
    depth * 4개의 underbar + "재귀함수는 자기 자신을 호출하는 함수라네"
    depth * 4개의 underbar + 라고 답변하였지.

    문제를 더 작은 단위로 쪼갤 수 있을 때 = depth < n일 때
    depth * 4개의 underbar + "재귀함수가 뭔가요?"
    depth * 4개의 underbar + "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
    depth * 4개의 underbar + 마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
    depth * 4개의 underbar + 그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
     */
    public static void printRecursiveAnswers(int n, int depth) {
        StringBuilder underbars = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            underbars.append("_");
        }
        String underbarsStr = underbars.toString();

        StringBuilder sb = new StringBuilder();

        if (n == depth) {
            sb.append(underbarsStr).append("\"재귀함수가 뭔가요?\"\n");
            sb.append(underbarsStr).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            sb.append(underbarsStr).append("라고 답변하였지.\n");
            return;
        }

        sb.append(underbarsStr).append("\"재귀함수가 뭔가요?\"\n");
        sb.append(underbarsStr).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        sb.append(underbarsStr).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        sb.append(underbarsStr).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

        printRecursiveAnswers(n, depth - 1);

        sb.append(underbarsStr).append("라고 답변하였지.");
    }
}
