import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
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
}