package com.programmers.lv1;

public class GetNumericValueOfS {
    // 2022.12.29(목) 0h45
    public static int solution(String s) {
        char firstCh = s.charAt(0);

        if (firstCh == '+') return getNumericValueOfS(s.substring(1));
        if (firstCh == '-') return getNumericValueOfS(s.substring(1)) * -1;
        else return getNumericValueOfS(s);
    }

    public static int getNumericValueOfS(String substr) {
        int length = substr.length();
        int result = 0;

        for (int i = 0; i < length; i++) {
            int num = Character.getNumericValue(substr.charAt(i));
            result += num * Math.pow(10, length - 1 - i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("-1234"));
        System.out.println(solution("1234"));
    }
}
