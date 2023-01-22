import java.util.*;

class Solution {
    public int solution(int n) {
        /*
        int quotient = n; // 3으로 나눈 몫
//        Stack<Integer> remainders = new Stack<>(); // list에 바로 담아서 앞뒤 반전 3진법을 바로 만들 수도 있음
        List<Integer> remainders = new ArrayList<>();

        while (quotient > 0) {
            quotient = n / 3;
            remainders.add(n % 3);
            n = quotient;
        }

        int decimalDigit = 0;
        for (int i = remainders.size() - 1; i >= 0; i--) {
            decimalDigit += (int) Math.pow(3.0, i) * remainders.get(remainders.size() - i - 1);
        }

        return decimalDigit;
        */
        
         // 다른 사람들의 풀이 참고
        String remainders = "";

        while (n > 0) {
            remainders = remainders + n % 3;
            n /= 3; // n = n / 3;
            System.out.println("n = " + n + ", remainders = " + remainders);
        }

        return Integer.parseInt(remainders, 3);
    }
}