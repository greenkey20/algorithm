package com.book.interviewsexposed;

// 2023.9.23(토) 1h10
public class FizzBuzz {
    public static String printFizzBuzz(int n) {
        if (n < 1) return null;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                sb.append("FizzBuzz ");
            } else if (i % 3 == 0) {
                sb.append("Fizz ");
            } else if (i % 5 == 0) {
                sb.append("Buzz ");
            } else {
                sb.append(i).append(" ");
            }
        }

        return sb.toString();
    }

    // 1h30 책 참고
    public static String alternativeFizzBuzz(int n) {
        if (n < 1) return null;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            String word = toWord(3, i, "Fizz") + toWord(5, i, "Buzz");

            if (word.equals("")) {
                sb.append(i).append(" ");
            } else {
                sb.append(word).append(" ");
            }
        }

        return sb.toString();
    }

    public static String toWord(int divisor, int num, String word) {
        return num % divisor == 0 ? word : "";
    }
}
