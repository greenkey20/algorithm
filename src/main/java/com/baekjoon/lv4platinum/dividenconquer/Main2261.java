package com.baekjoon.lv4platinum.dividenconquer;

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
//        List<int[]> pointsList = new ArrayList<>();

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

        // points 배열 잘 만들어지나 확인하는 콘솔 출력
        /*
        for (int i = 0; i < points.length; i++) {
            // v1 list에 int[x좌표, y좌표]로 점들을 만들어 담으려고 함
//            System.out.println(Arrays.toString(pointsList.get(i))); // todo

            // v2 Point 클래스 + Point 객체 배열에 점들을 담으려고 함
            System.out.println(points[i].toString());
        }
         */

        // 2023.6.1(목) 0h15 reference 보면서 작성해봄 -> (자다가 일어나서)5h45 제출 시 '틀렸습니다'
        // 문제 해결 로직 + 결과 출력
        System.out.println(closest(0, n - 1));
    }

    public static int closest(int start, int end) {
        // point[start] ~ point[end] 원소가 3개 이하이면, brute force로 거리 구해서 반환
        if (end - start + 1 < 4) {
            return bruteDistance(start, end);
        }

        int mid = (start + end) / 2;

        int left = closest(start, mid);
        int right = closest(mid + 1, end);

        int minDistance = Math.min(left, right);

        int band = middleBand(start, mid, end, minDistance);
        return Math.min(minDistance, band);
    }

    private static int bruteDistance(int start, int end) {
        int minDistance = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                int thisDistance = calculateDistance(points[i], points[j]);
                minDistance = Math.min(minDistance, thisDistance);
            }
        }

        return minDistance;
    }

    private static int middleBand(int start, int mid, int end, int minDistance) {
        int xDistance; // 5h40 나의 질문 = 변수 선언 시 초기화 해두는 것과 안 해두는 것의 성능 차이가 있나?

        List<Point> list = new ArrayList<>();

        // 후보군 추출
        int midX = points[mid].x;
        for (int i = start; i <= end; i++) {
            xDistance = points[i].x - midX;

            if (xDistance * xDistance < minDistance) {
                list.add(points[i]);
            }
        }

        // 후보군들을 y좌표 기준으로 정렬 -> 5h 나의 고민 = 이 정렬이 꼭 필요한가? 내 생각에는 이미 points 배열에서 x좌표 및 y좌표로 정렬되어있기 때문에 필요 없을 것 같은데..
//        Collections.sort(list);

        int yDistance;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 1; j < list.size(); j++) {
                yDistance = list.get(i).y - list.get(j).y;

                if (yDistance * yDistance < minDistance) {
                    minDistance = Math.min(calculateDistance(list.get(i), list.get(j)), minDistance);
                } else {
                    break;
                }
            }
        }

        return minDistance;
    }

    // 위에서 bruteDistance()로 작성한 메서드의 first draft..
    public static int binarySearch(Point[] points) {
        int min = 0;

        // 비교해야 하는 점들이 2~3개일 때 분할정복으로 거리 구하기 불가능 -> brute force로 최단거리 찾기
        if (true) {

        }

        return min;
    }

    // 두 점 사이의 거리(의 제곱, 문제에서 반환해야 하는 값) 구하는 메서드
    public static int calculateDistance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
}
