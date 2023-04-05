package com.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 2023.4.5(수) 22h30 ~ 22h55 v1 맞았습니다
// v1 연습장에 입/출력 예시1 그려서 생각해보고 구현해봄
public class ClearDesktop {
    public static int[] solution(String[] wallpaper) {
//        int[] answer = new int[4];

        // 22h50 한 번 콘솔 출력해보고 생각해보니, list 말고 set에 좌표들을 모아도 되는데, 정렬하고 최소/최대값 접근하기 편하려면 list가 나을 것 같아서 list로 하기로 함
        // wallpaper의 각 원소를 순회하며 x 좌표들을 list에 모음 -> 최소값 = lux, 최대값+1 = rdx
        List<Integer> listOfX = new ArrayList<>();

        // wallpaper[i]의 각 원소를 순회하며 y 좌표들을 list에 모음 -> 최소값 = luy, 최대값+1 = rdy
        List<Integer> listOfY = new ArrayList<>();

        for (int i = 0; i < wallpaper.length; i++) {
            String str = wallpaper[i];

            if (str.contains("#")) {
                listOfX.add(i);
            }

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '#') {
                    listOfY.add(j);
                }
            }
        }
//        System.out.println(listOfY); // todo
//        System.out.println(listOfX); // todo

        // listOfX에서 최소/대값 구하기
        int lux = listOfX.get(0);
        int rdx = listOfX.get(listOfX.size() - 1) + 1;

        // listOfY에서 최소/대값 구하기
        Collections.sort(listOfY);
        int luy = listOfY.get(0);
        int rdy = listOfY.get(listOfY.size() - 1) + 1;

        return new int[]{lux, luy, rdx, rdy};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{".#...", "..#..", "...#."}))); // 0,1,3,4
        System.out.println(Arrays.toString(solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."}))); // 1,3,5,8
        System.out.println(Arrays.toString(solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."}))); // 0,0,7,9
        System.out.println(Arrays.toString(solution(new String[]{"..", "#."}))); // 1,0,2,1
    }
}
