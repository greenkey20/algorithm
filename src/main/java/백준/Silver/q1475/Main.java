package 백준.Silver.q1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

// 2022.12.24(토) 4h50 문제 읽음
// 입력으로 주어진 숫자 하나하나 읽으며 set에 담고, set에 있으면 새로운 세트 만듦(단, 6이나 9인 경우 set에 있다면 각각 9/6으로 바꿔서 set에 있는지 다시 검사) -> set를 담는 list를 만들고, 최종적으로 그 list의 size를 반환
public class Main {
    // 2022.12.24(토) 19h15 구현 시작 -> 입/출력 예시는 다 통과했지만 19h35 제출 시 틀렸습니다 -> 반례 9999444로 디버깅
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strN = br.readLine();

        // 문제 해결 로직

        // 출력
        System.out.println(getNumOfDigitSet(strN));

    }

    public static int getNumOfDigitSet(String strN) {
        int result = 0;

        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        for (int i = 0; i < strN.length(); i++) {
            list.add(new HashSet<Integer>());
        }

        for (int i = 0; i < strN.length(); i++) {
            int num = Character.getNumericValue(strN.charAt(i));

            for (int j = 0; j < strN.length(); j++) {
                HashSet<Integer> thisSet = list.get(j);

                if (!thisSet.contains(num)) {
                    thisSet.add(num);
                    break;
                } else if (num == 6 && !thisSet.contains(9)) {
                    thisSet.add(9);
                    break;
                } else if (num == 9 && !thisSet.contains(6)) {
                    thisSet.add(6);
                    break;
                }
            }
        }

        for (int i = 0; i < strN.length(); i++) {
            if (list.get(i).size() != 0) result++;
        }

        return result;
    }
}