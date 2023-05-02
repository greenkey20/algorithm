package com.baekjoon.lv3gold.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 2023.4.26(수) 23h45 ~ 0h30 v1 while문 안 thisRouter 관련 array index out of bounds exception -> 2023.4.29(토) 23h50 v2 이 예외는 처리하였으나, 프로그램 로직 안 맞는 듯
// -> 2023.4.30(일) 1h5 아직 동작 안 하는데, 어떻게 수정해야 할지 모르겠다 -> 일단 프로그램을 작은 단위 메서드/모듈들로 나눠봄 according to Eddie's tips + 2023.5.1(월) 22h10 메서드 호출 구조 조금 수정? 안 하는 게 나을 듯
/* 문제 이해에 시간 걸렸는데, reference https://st-lab.tistory.com/277에 따라 "포인트는 집 간 최소 거리 이상일 때 설치가 가능하다"
내 코드가 동작을 안 하기에 2023.5.1(월) 22h15 reference logic 보고 옴 v3 = 입/출력예시에 대해서는 (드디어) 동작하는데, 23h5 제출 시 '틀렸습니다'
 */
public class Main2110 {
    public static int n;
    public static int c;
    public static Integer[] houses;

    // main function/method
    public static void main(String[] args) throws IOException {
        // 형식1) 백준 웹사이트 요구 사항 = through data layer v2
        presentSolution(baekjoonIO());

        // 형식2) 테스트용 = through data layer v1
//        presentSolution(myTestCase1());
    }

    // 데이터 입력받기 v1 = data layer v1
    public static int myTestCase1() {
        n = 5;
        c = 3;
        houses = new Integer[]{1, 2, 8, 4, 9};

        return binarySearch(houses);
    }

    // 데이터 입력받기 v2 = data layer v2
    public static int baekjoonIO() throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 집의 개수
        c = Integer.parseInt(st.nextToken()); // 공유기의 개수

        houses = new Integer[n];

        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        return binarySearch(houses);
    }

    // 결과 출력 = presentation layer
    public static void presentSolution(int result) {
        System.out.println(result);
    }

    // 문제 해결 로직 = business logic layer
    public static int binarySearch(Integer[] houses) {
        Arrays.sort(houses);
        List<Integer> housesList = new ArrayList<>(Arrays.asList(houses));
        System.out.println("houses 배열 = " + Arrays.toString(houses)); // todo

        // v1, v2 나의 구현
        // houses 간 거리에 대해 이분탐색
        /*
        int left = houses[0];
        int right = houses[n - 1] - houses[0]; // upperBound의 의미를 오늘은 조금 다르게 정의해서 풀어보기로 함
        int mid = 0;
        int numOfRouters = 0;

        int[] routers = new int[c]; // 설치되는 공유기의 집 번호를 배열에 하나씩 넣음
        routers[0] = houses[0]; // 첫번째 집에는 공유기를 항상? 설치하게 됨
        int thisRouter = 0;
        int numOfHouseOfThisRouter = 0;
        int i = 0;
        int j = 0;

        while (left < right) {
            mid = (left + right) / 2;
            System.out.println("left = " + left + ", right = " + right + ", mid = " + mid); // todo

            for (j = 1; i < c && numOfHouseOfThisRouter + j < n; ) {
                thisRouter = routers[i];
                numOfHouseOfThisRouter = housesList.indexOf(thisRouter);
                int nextHouse = houses[numOfHouseOfThisRouter + j];

                System.out.println("현재 가장 최근에 설치된 공유기 집 = " + thisRouter + ", 다음 집 = " + nextHouse + ", 현재 i = " + i + ", j = " + j); // todo

                if (nextHouse - thisRouter >= mid) {
                    routers[i + 1] = nextHouse;
                    numOfRouters++;
                    numOfHouseOfThisRouter += j;
                    i++;
                    j = 1;
                    System.out.println("공유기 설치 -> " + Arrays.toString(routers)); // todo
                } else {
                    j++;
                }
            }

            if (numOfRouters < c) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
         */

        // 2023.5.1(월) 22h15 reference 참고 후 구현
        int left = houses[0];
        int right = houses[n - 1] - houses[0];
//        int right = (houses[n - 1] - houses[0]) / (n - 1) + 1;
        int mid = 0;

        while (left < right) {
            mid = left + (right - left) / 2;
            System.out.println("left = " + left + ", right = " + right + ", mid = " + mid); // todo

            int numOfRouters = 1;
            int numOfLastRouter = houses[0];

            for (int i = 1; i < n; i++) {
                int numOfThisHouse = houses[i];

                if (numOfThisHouse - numOfLastRouter >= mid) {
                    numOfLastRouter = numOfThisHouse;
                    numOfRouters++;
                    System.out.println("가장 최근 공유기 설치된 집 = " + numOfLastRouter + ", 설치된 공유기 총 개수 = " + numOfRouters); // todo
                }
            }

            if (numOfRouters < c) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return mid;
    }
}
