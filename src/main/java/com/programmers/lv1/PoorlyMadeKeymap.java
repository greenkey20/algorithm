package com.programmers.lv1;

import java.util.Arrays;

// 2023.4.2(일) 19h45 ~ 20h5 v1 제대로 동작하지 않음 -> 20h25 v2 여전히 잘 안 됨
public class PoorlyMadeKeymap {
    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        // target(만들고자 하는 문자열) 하나하나 확인
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i]; // 금번 확인 target
            System.out.println("금번 확인 target = " + target); // todo
            int count = 0;

            // 금번 확인 문자열 target의 각 글자를 누르는 최소 횟수를 찾아야 함
            for (int j = 0; j < target.length(); j++) {
                char ch = target.charAt(j);
                System.out.println("금번 확인 문자 ch = " + ch); // todo
                int min = 0;
                int check = 0;

                // 금번 확인 문자열 target의 j번째 글자 ch를 keymap의 각 자판으로 입력하려고 했을 때
                // 각 자판에서는 최소 몇 번을 눌러야 하는지, keymap 크기만큼의 배열에 담아둠 -> 이 배열의 원소 중 가장 작은 수를 count에 더해둠
                int[] touches = new int[keymap.length];
                for (int k = 0; k < keymap.length; k++) {
                    int touch = keymap[k].indexOf(ch) + 1;
                    touches[k] = touch;
                    check += touch;
                }
                System.out.print("금번 확인 문자를 각 자판에서 몇 번 눌러야 찾는지, 각 자판별 data = "); // todo
                System.out.println(Arrays.toString(touches)); // todo

                if (check == 0) {
                    count = -1;
                } else {
                    min = touches[0];

                    for (int k = 0; k < touches.length; k++) {
                        if (touches[k] < min) min = touches[k];
                    }

                    count += min;
                }
            }

            answer[i] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"}))); // 9, 4
        System.out.println(Arrays.toString(solution(new String[]{"AA"}, new String[]{"B"}))); // -1
        System.out.println(Arrays.toString(solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA", "BGZ"}))); // 4, 6
    }
}
