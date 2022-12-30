package 프로그래머스.lv1.q1845;

import java.util.HashSet;
import java.util.Set;

class Solution {
    // 2022.11.15(화) 23h45
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num)) {
                set.add(num);
            }
        }

        // nums 배열 중 중복되지 않은 포켓몬들이 많이 있더라도 최대 (nums / 2)만큼만 가져갈 수 있음 vs 중복되지 않은 포켓몬들이 (nums / 2)보다 적다면 그 중복되지 않은 포켓몬들의 종류(set.size())만큼 가져가면 됨
        if (nums.length / 2 <= set.size()) {
            answer = nums.length / 2;
        } else {
            answer = set.size();
        }

        return answer;
    }
}