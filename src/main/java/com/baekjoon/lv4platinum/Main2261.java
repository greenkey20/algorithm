package com.baekjoon.lv4platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 2023.5.6(토) 23h
/* 문제 읽으며, 연습장에 끄적여봄 -> 분할정복을 어떻게 적용하는지는 모르겠고, 문제 분류 중 '스위핑(sweeping)' 검색해봄
references = https://blog.naver.com/kks227/220907708368
레퍼런스에서 제시한 예시 문제
골드5 2170 선 긋기 - sweeping, 정렬
플래티넘4 5419 북서풍 - sweeping, 자료구조, segment tree, 값/좌표 압축
플래티넘2 3392 화성 지도 - sweeping, 자료구조, segment tree

나의 연습장 idea = n개 요소 중 서로 다른 2개를 순서 상관 없이 뽑는 조합
입력받은 점들을 x좌표 순서대로 set에 넣음(여러 점이 같은 좌표를 가질 수도 있음) -> 각 조합의 거리로 min 업데이트 해가며 brute force?
 */
public class Main2261 {
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> pointsSet = new TreeSet<>(); // int[]의 TreeSet을 만들면 Construction of sorted collection with non-comparable elements
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            pointsSet.add(str);
        }

//        System.out.println(pointsSet);

        List<int[]> pointsList = new ArrayList<>();
        Iterator<String> it = pointsSet.iterator();
        while (it.hasNext()) {
            String pointStr = it.next();
            String[] pointStrSplit = pointStr.split(" ");
//            System.out.println(Arrays.toString(pointStrSplit));
            int[] nums = new int[2];
            for (int i = 0; i < 2; i++) {
                nums[i] = Integer.parseInt(pointStrSplit[i]);
            }

            pointsList.add(nums);
//            pointsList.add(new Integer[]{Integer.parseInt(pointStrSplit[0], Integer.parseInt(pointStrSplit[1]))});
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(pointsList.get(i)));
        }

        // 문제 해결 로직

        // 결과 출력
        System.out.println();
    }
}
