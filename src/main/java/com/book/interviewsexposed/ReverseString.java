package com.book.interviewsexposed;

// 2023.9.28(목) 21h5
public class ReverseString {

    /**
     * 문자열을 뒤집기 위한 메서드를 작성하라.
     *
     * 책 내용 = 이 코드 실행에는 대용량 메모리가 필요하다.
     * 구조상으로는 원 String 객체 s와 StringBuilder 객체만 메모리에 있으면 되는 구조라 단순하지만, GB 크기의 데이터를 뒤집으려면 문제가 될 수 있음
     *
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

    // 22h40 책 참고

    /**
     * String 인스턴스를 StringBuilder 객체로 로딩해 원래 순서의 String 객체를 뒤집는다 <- s의 처음~끝까지 글자 하나하나 순회하면서 s의 끝을 기준으로 같은 길이만큼 떨어진 문자와 치환
     *
     * @param s
     * @return
     */
    public static String inPlaceReverseString(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length() / 2; i++) {
            char temp = s.charAt(i);

            int endIdx = s.length() - 1 - i;
            sb.setCharAt(i, s.charAt(endIdx));
            sb.setCharAt(endIdx, temp);
        }

        return sb.toString();
    }
}
