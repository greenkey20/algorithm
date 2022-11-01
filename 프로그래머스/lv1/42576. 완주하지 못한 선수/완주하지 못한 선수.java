import java.util.*;

// 2022.11.2(수) 4h
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        /* v1
        ArrayList<String> completionList = new ArrayList<>(Arrays.asList(completion));
        
        // 참여자 명단을 순회하면서
        for (int i = 0; i < participant.length; i++) {
            // i번째 참여자가 완주자 명단에 있는지 확인 -> 없는 경우 그 i번째 참여자의 이름을 return해야 함
            if (!completionList.contains(participant[i])) {
                answer = participant[i];
            }
        }
        */
        
        // v2 동명이인 처리를 위해 수정
        // 오름차순 정렬된 참여자 명단을 순회하면서, i번째 참여자 이름과
        /*
        for (int i = 0; i < participant.length; i++) {
            // 오름차순 정렬된 완주자 명단의 i번째 참여자 이름이 같은지 확인
            for (int j = 0; j < completion.length; j++) {
                if (i == j) {
                    if (!participant[i].equals(completion[i])) {                
                        answer = participant[i];
                        return answer;
                    }
                } else { // 오름차순 정렬된 참여자 명단 상 가장 마지막에 있는 사람까지 순회하게 되었다면, 이 사람이 완주하지 못한 사람임
                    answer = participant[i];
                }    
            }          
        }
        */
        
        // v3 효율성 제고를 위해 수정
        for (int i = 0; i < participant.length - 1; i++) {
            if (!participant[i].equals(completion[i])) {                
                answer = participant[i];
                return answer;
            }
        }
        
        answer = participant[participant.length - 1];
        return answer;
    }
}