import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
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
}