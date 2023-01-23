package com.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoRanks {
    // 2023.1.23(월) 22h10 -> 22h55 작성했는데, 왜 의도한대로 동작하지 않는지 아직 모르겠음
    public static int[] solution(int[] lottos, int[] winNums) {
        // winNums 배열을 List<Integer>로 변환
//        ArrayList<Integer> winNumsList = new ArrayList<Integer>(Arrays.asList(winNums));
//        List<Integer> winNumsList =Arrays.stream(winNums).collect(Collectors.toList());
        List<Integer> winNumsList = new ArrayList<>();

        for (int winNum : winNums) {
            winNumsList.add(winNum);
        }

        int zeroCount = 0;
        int winNumCount = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
            } else if (winNumsList.contains(lotto)) {
                winNumCount++;
            }
        }

        int highestCount = winNumCount + zeroCount;
        int lowestCount = winNumCount;
        int[] counts = new int[]{highestCount, lowestCount};

        int[] ranks = new int[2];

        /*
        int highestRank = 0;
        int lowestRank = 0;

        if (highestCount == 6) {
            highestRank = 1;
        } else if (highestCount == 5) {
            highestRank = 2;
        }


        switch (highestCount) {
            case 6:
                highestRank = 1;
                break;
        }
         */

        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            int rank = ranks[i]; // Variable 'rank' is assigned but never accessed -> 나의 질문 = why is this?

            switch (count) {
                case 6:
                    rank = 1;
                    break;
                case 5:
                    rank = 2;
                    break;
                case 4:
                    rank = 3;
                    break;
                case 3:
                    rank = 4;
                    break;
                case 2:
                    rank = 5;
                    break;
                case 1:
                    rank = 6;
                    break;
            }
        }

        return ranks;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
        System.out.println(Arrays.toString(solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25})));
        System.out.println(Arrays.toString(solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35})));
    }
}
