package com.book.interviewsexposed;

// 2023.9.28(목) 21h5
public class ReverseString {

    /**
     * 문자열을 뒤집기 위한 메서드를 작성하라.
     * @param s
     * @return
     */
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char thisCh = s.charAt(i);
            sb.append(thisCh);
        }

        return sb.toString();
    }
}
