package com.programmers.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PyramidSalesOfToothbrush {
    // 2023.3.19(일) 18h55
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        List<List<String>> listOfBranches = new ArrayList<>();

        // enroll[] 배열 원소를 하나하나 referral[] 원소와 비교해서 누가 누구와 연결되어 있는지 부모 노드부터 자식 노드까지 인접리스트로 그래프를 만든다
        for (int i = 0; i < enroll.length; i++) {
            if (referral[i].equals("-")) {
                List<String> newBranch = new ArrayList<>();
                newBranch.add(enroll[i]);
                listOfBranches.add(newBranch);
            } else {
                for (List<String> list : listOfBranches) {
                    if (list.contains(referral[i])) {
                        list.add(enroll[i]);
                    }
                }
            }
        }

        // todo 19h10 출력해서 봤는데, mary의 자식들의 자식들끼리 묶은 그래프는 어떻게 만들지? mary의 자식별 별도로 만들어야 하나..?
        for (List<String> list : listOfBranches) {
            System.out.println(list.toString());
        }

        // (사람 이름, 이익) map의 list를 만든다

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10})));
    }
}
