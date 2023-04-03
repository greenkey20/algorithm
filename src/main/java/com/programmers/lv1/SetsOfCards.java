package com.programmers.lv1;

import java.util.Stack;

// 2023.4.3(월) 19h20 ~ 19h33 v1 맞았습니다
// 문제 읽으면서 어떤 자료구조 써봐야겠다(stack) 생각한 다음에는, pseudo code 작성 없이 한 줄 한 줄 구현해 나갔다
public class SetsOfCards {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        for (int i = cards1.length - 1; i >= 0; i--) {
            String card1 = cards1[i];
            stack1.add(card1);
        }

        for (int i = cards2.length - 1; i >= 0; i--) {
            String card2 = cards2[i];
            stack2.add(card2);
        }

        //System.out.println("stack1 = " + stack1);
        //System.out.println("stack2 = " + stack2);

        for (int i = 0; i < goal.length; i++) {
            String goalWord = goal[i];

            if (!stack1.isEmpty()) {
                if (goalWord.equals(stack1.peek())) {
                    stack1.pop();
                    continue;
                }
            }

            if (!stack2.isEmpty()) {
                if (goalWord.equals(stack2.peek())) {
                    stack2.pop();
                    continue;
                }
            }

            return "No";
        }

        return "Yes";
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"})); // Yes
        System.out.println(solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"})); // No
    }
}
