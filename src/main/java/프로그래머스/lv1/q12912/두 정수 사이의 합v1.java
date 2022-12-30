package 프로그래머스.lv1.q12912;

class SolutionV1 {
    // 2022.11.26(토) 23h50
    public long solution(int a, int b) {
        long answer = 0;
        long smaller = a;
        long bigger = b;

        if (a == b) answer = a;
        else {
            if (a > b) {
                smaller = b;
                bigger = a;
            }

            for (long i = smaller; i <= bigger; i++) {
                answer += i;
            }
        }

        return answer;
    }

    /* 회고
    1. 다시 잘 생각해보면 a와 b가 같은 경우에 대해 굳이 별도 조건문 처리할 필요 없음
    2. reference1 = 등차수열의 합 공식 활용
    3. reference2 = 3항 연산자 활용해서 for문 1개로 답안 작성 가능
    4. Math 클래스의 min(a, b), max(a, b) 활용도 가능
     */
    public long solutionReference1(int a, int b) {
        return sumAtoB(Math.min(a, b), Math.max(b, a));
    }

    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }

    public long solutionReference2(int a, int b) {
        long answer = 0;
        for (int i = ((a < b) ? a : b); i <= ((a < b) ? b : a); i++)
            answer += i;

        return answer;
    }

    // 2022.11.27(일) 0h35 회고 내용 바탕으로 응용해서 내가 작성해본 것 -> 통과
    public long solutionReference3(int a, int b) {
        long answer = 0;

        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            answer += i;
        }

        return answer;
    }
}