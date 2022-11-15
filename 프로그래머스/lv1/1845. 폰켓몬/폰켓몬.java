import java.util.*;

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
        
        if (nums.length / 2 <= set.size()) {
            answer = nums.length / 2;
        } else {
            answer = set.size();
        }
        
        return answer;
    }
}