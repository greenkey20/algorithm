package com.programmers.lv1;

public class SplitString {
    // 2023.3.22(수) 18h35 ~ 19h20 v1 = 아직 못 풂
    public static int solution(String s) {
        int answer = 0;

        int countX = 1;
        int countOthers = 0;

        StringBuilder sbS = new StringBuilder(s);

        char x = s.charAt(0);
        StringBuilder sbX = new StringBuilder(x);

        StringBuilder sbOthers = new StringBuilder();

        for (int i = 1; i < s.length() - 1; ) {
//            if (i > 1) {
//                x = s.charAt(i);
//            }

            char next1 = s.charAt(i + 1);

            if (next1 == x) {
                countX++;
                sbX.append(next1);
            } else {
                countOthers++;
                sbOthers.append(next1);
            }

            if (countX == countOthers) {
                answer++;
                sbS = sbS.delete(0, countX + countOthers);
                i = i + countX + countOthers;

                countX = 1;
                countOthers = 0;

                x = sbS.charAt(0);

                sbX = new StringBuilder(x);
                sbOthers = new StringBuilder();

                System.out.println("sbS = " + sbS + ", i = " + i); // todo
            } else {
                i++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("banana")); // 3
        System.out.println(solution("abracadabra")); // 6
        System.out.println(solution("aaabbaccccabba")); // 3
    }
}
