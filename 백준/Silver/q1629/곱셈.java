import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

// 2023.5.4(목) 18h15 ~ 18h30 v1 Math 클래스 활용해서 제출해보기 = 틀렸습니다, Math.pow() 결과도 long 자료형 범위를 넘어갈 수 있기에 이렇게 풀면 틀린다
// ~ 18h50 v2 = 시간 초과 = 왜일까? 어느 부분을 개선해야 할까?
// ~19h10 v3 = 모듈로 연산 포함 ㄹ턴하도록 변경했는데, 여전히 시간 초과
// 20h50 ~ 21h5 v4 = 분할정복 로직 수정 = 여전히 틀렸습니다
/* 2023.5.5(금) 21h35 references 참고하며 다시 검토 -> 21h55 맞았습니다

A, B, C는 모두 2,147,483,647(Java int 자료형의 최대값) 이하의 자연수 -> 이런 A, B를 거듭제곱하면 long 자료형 범위도 넘어감 + 시간 초과도 될 거라고 함ㄴ
reference = https://st-lab.tistory.com/237
https://rujang.tistory.com/entry/%EB%B0%B1%EC%A4%80-1629%EB%B2%88-%EA%B3%B1%EC%85%88-CC
https://velog.io/@junttang/BOJ-1629-곱셈-해결-전략-C
 */
public class Main {
    //    public static int a;
//    public static int b;
    public static int base;
    public static int divisor;

    // main()
    public static void main(String[] args) throws IOException {
        int exponent = baekjoonInput();

        long result = baseRaisedToPowerOfExponent(exponent);

        presentSolution(result);
    }

    // 데이터 입력받기
    public static int baekjoonInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // e.g. 10 11 12 -> 4
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        base = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        divisor = Integer.parseInt(st.nextToken());

        return b;
    }

    // 결과 출력
    public static void presentSolution(long result) {
//        System.out.println(result % c);
        System.out.println(result);
    }

    // 문제 해결 로직
    public static long baseRaisedToPowerOfExponent(int exponent) {
        // v2
        if (exponent == 1) {
            return base % divisor; // 21h15 이거 수정했는데도, 여전히 틀렸습니다
        }

        // v4 references 참고해서 다시 작성
        long divide = baseRaisedToPowerOfExponent(exponent / 2);

        if (exponent % 2 == 1) {
            return divide * divide % divisor * base % divisor;
        }

        return divide * divide % divisor;

        // v2
        /*
        if (exponent % 2 == 0) {
            return (baseRaisedToPowerOfExponent(base, exponent / 2, divisor) % divisor) * (baseRaisedToPowerOfExponent(base, exponent / 2, divisor) % divisor) % divisor;
        }

        return (baseRaisedToPowerOfExponent(base, exponent / 2, divisor) % divisor) * (baseRaisedToPowerOfExponent(base, exponent / 2, divisor) % divisor) * base % divisor;
         */
//        return baseRaisedToPowerOfExponent(base, exponent / 2, divisor) * baseRaisedToPowerOfExponent(base, exponent / 2, divisor) * baseRaisedToPowerOfExponent(base, 1, divisor);

        // v1
//        return (long) (Math.pow(base, exponent)) % divisor;
    }

    public static long baseRaisedToPowerOfExponentMemoized(int base, int exponent, int divisor) {
        return 0;
    }

}
