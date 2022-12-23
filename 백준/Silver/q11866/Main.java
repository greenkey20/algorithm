package 백준.Silver.q11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 2022.6.16(목) 23h50
 * @author greenpianorabbit
 * 요세푸스 문제 = 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
 
 * 2022.6.21(화) 23h55
 * 이 문제에서 왜/어떻게 queue를 사용해야 하는가?
 */
public class Main {
    // 2022.6.20(월) 23h50
    public static void main(String[] args) throws IOException {
		/*
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // n명의 사람들이 앉아있음
		int k = sc.nextInt(); // k번째 사람을 제거함
		
		sc.close();
		 */
        // 2022.12.23(금) 21h50 다시 도전
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        // 문제 해결 로직

        // 출력
        System.out.println(getJosephusPermutation(N, K));
    }

    public static String getJosephusPermutation(int N, int K) {
        String result = "<";

        // idea1)
//		Queue<Integer> queue = new LinkedList<>();
        // idea2) 인덱스가 있어야 할 것 같아서 배열로 바꿈
//		int[] queue = new int[N];
        // idea3) 30분 정도 문제 봤는데 접근 방향 잘 모르겠어서 구글링 -> https://www.geeksforgeeks.org/josephus-problem/ 중 이해(가능)한 방법(list 사용 재귀)으로 구현해보려고 했으나, 제대로 이해 못한 것 같음
        // 대신, 종이에 단계별 list 모양 써서 remove해야 하는 index의 패턴 찾음
        ArrayList<Integer> queue = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int out = 0;
        int index = K - 1;

        while (true) {
            out = queue.remove(index);
            result = result + out + ", ";

            if (queue.size() > 0) {
                index = (index + K - 1) % queue.size(); // 다음 remove 대상 = 이번에 remove한 index로부터 K만큼 진행하지만, list의 크기가 1씩 감소하므로 -1
            } else { // queue의 크기가 0일 때 위 계산을 하려고 하면 0으로 나누려고 하는 arithmetic exception 발생 -> while문 조건절 대신 여기서 조건 검사
                break;
            }
        }

        result = result.substring(0, result.length() - 2);
        return result + ">";
    }

}
