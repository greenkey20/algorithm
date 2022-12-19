package 백준.Silver.q2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

// 2022.12.17(토) 문제 읽고 와서 7h45 ~ 7h50 초안 작성 -> 2022.12.18(일) 0h30 이어서 작성 -> 1h50 1시간 이상 고민했으나 일단 아직 못 품
public class Main {
    static ArrayList<Integer> primeNumbers = new ArrayList<>();
    static LinkedHashSet<Integer> sieveSet = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]); // 2 ~ N까지 모든 정수 중에서
        int K = Integer.parseInt(inputs[1]); // 에라토스테네스의 체에 따라 K번째로 지우는 수를 return

        // 문제 해결 로직
        getPrimeNumbers(N); // 2 ~ N 사이의 모든 소수를 구해서 list에 담아둠
        kThSieve(N, K); // 에라토스테네스의 체에 따라 지워지는 수들을 차례로 linkedHashSet에 담음
        Integer[] sieveArr = sieveSet.toArray(new Integer[0]); // 지워진 수들 중 맨 마지막 요소에 접근하기 위해(set은 인덱스가 없음) 배열로 바꿈

        // 출력
        System.out.println(sieveArr[sieveArr.length - 1]); // 지워진 수들의 배열에서 가장 마지막 요소를 return/출력
    }

    public static void kThSieve(int N, int K) {
        for (int i = 0; i < primeNumbers.size(); i++) {
            int thisPrimeNum = primeNumbers.get(i);
            int divisor = N / thisPrimeNum;

            // 2022.12.19(월) 18h5 계속 작성
            for (int j = 1; j <= divisor; j++) {
                sieveSet.add(j * thisPrimeNum);
//                System.out.println("j가 " + j + "일 때 지워진 수들의 set = " + sieveSet + " (크기는 " + sieveSet.size() + ")"); // todo
                if (sieveSet.size() == K) {
                    return;
                }
            }
        }
    }

    // 2 ~ N 사이의 모든 소수를 먼저 구함
    public static void getPrimeNumbers(int N) {
        primeNumbers.add(2);

        for (int i = 3; i <= N; i++) {
            boolean isPrimeNumber = true; // 2022.12.19(월) 18h20 실행 시 소수 [2, 3, 5, 7]만 담겨서 디버깅해봄 -> i가 11일 때 isPrimeNumber가 여전히 false임을 발견하고, 이 변수의 선언/초기화 위치 변경
            if (i % 2 == 0) continue;

            for (int j = 3; j <= Math.sqrt(i); j += 2) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }

            if (isPrimeNumber) primeNumbers.add(i);
        }

//        System.out.println(primeNumbers); // todo
    }
}