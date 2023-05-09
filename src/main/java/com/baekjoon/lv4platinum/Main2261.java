package com.baekjoon.lv4platinum;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

// 2023.5.6(토) 23h
/* 문제 읽으며, 연습장에 끄적여봄 -> 분할정복을 어떻게 적용하는지는 모르겠고, 문제 분류 중 '스위핑(sweeping)' 검색해봄
references = https://blog.naver.com/kks227/220907708368
레퍼런스에서 제시한 예시 문제
골드5 2170 선 긋기 - sweeping, 정렬
플래티넘4 5419 북서풍 - sweeping, 자료구조, segment tree, 값/좌표 압축
플래티넘2 3392 화성 지도 - sweeping, 자료구조, segment tree

나의 연습장 idea = n개 요소 중 서로 다른 2개를 순서 상관 없이 뽑는 조합
입력받은 점들을 x좌표 순서대로 set에 넣음(여러 점이 같은 좌표를 가질 수도 있음) -> 각 조합의 거리로 min 업데이트 해가며 brute force?

2023.5.9(화) 22h10
오늘의 reference = https://st-lab.tistory.com/256 -> 알고리즘 참고 -> ~22h50 v2 기본 세팅 작성
 */
public class Main2261 {
    // 입력받는 점들의 배열
    private static Point[] points;

    // 입력받은 점들을 표현하기 위한 클래스
    private static class Point {
        // 멤버 변수 = 각각의 좌표는 절대값이 10,000을 넘지 않는 정수
        int x;
        int y;

        // 생성자
        public Point() {

        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 탐색해야 하는, 입력받는, 점들의 (최대)개수 = 2 ≤ n ≤ 100,000

        // br.readLine() 결과 String(문자열)을 set에 담아서 중복되는 점은 하나만 저장
        Set<String> pointsSet = new TreeSet<>(); // int[]의 TreeSet을 만들면 Construction of sorted collection with non-comparable elements
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            pointsSet.add(str);
        }
//        System.out.println(pointsSet);

        // x좌표 및 y좌표 오름차순으로 정렬
        // v1 list에 int[x좌표, y좌표]로 점들을 만들어 담으려고 함
        List<int[]> pointsList = new ArrayList<>();

        // v2 Point 클래스 + Point 객체 배열에 점들을 담으려고 함
        points = new Point[pointsSet.size()];
        int idx = 0;

        Iterator<String> it = pointsSet.iterator();
        while (it.hasNext()) {
            String pointStr = it.next();
            String[] pointStrSplit = pointStr.split(" ");
//            System.out.println(Arrays.toString(pointStrSplit));

            // v2 Point 클래스 + Point 객체 배열에 점들을 담으려고 함
            Point p = new Point(Integer.parseInt(pointStrSplit[0]), Integer.parseInt(pointStrSplit[1]));

            points[idx] = p;
            idx++;

            // v1 list에 int[x좌표, y좌표]로 점들을 만들어 담으려고 함
            /*
            int[] nums = new int[2];
            for (int i = 0; i < 2; i++) {
                nums[i] = Integer.parseInt(pointStrSplit[i]);
            }

            pointsList.add(nums);
             */
//            pointsList.add(new Integer[]{Integer.parseInt(pointStrSplit[0], Integer.parseInt(pointStrSplit[1]))});
        }

        for (int i = 0; i < points.length; i++) {
            // v1 list에 int[x좌표, y좌표]로 점들을 만들어 담으려고 함
//            System.out.println(Arrays.toString(pointsList.get(i))); // todo

            // v2 Point 클래스 + Point 객체 배열에 점들을 담으려고 함
            System.out.println(points[i].toString());
        }

        // 문제 해결 로직


        // 결과 출력
        System.out.println();
    }

    public static int binarySearch(Point[] points) {
        int min = 0;

        // 비교해야 하는 점들이 2~3개일 때 분할정복으로 거리 구하기 불가능 -> brute force로 최단거리 찾기
        if (true) {

        }

        return min;
    }

    // 두 점 사이의 거리(의 제곱, 문제에서 반환해야 하는 값) 구하는 메서드
    public static int calculateDistance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) * (p1.y - p2.y) * (p1.y - p2.y);
    }
}
