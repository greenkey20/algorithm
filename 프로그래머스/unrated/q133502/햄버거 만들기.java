package 프로그래머스.unrated.q133502;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        // 2022.11.18(금) 11h55 로컬(IntelliJ)에서 comments/references commit/push하다가 검토 안 하고 merge했더니, 다른 사람 코드 동작 실험 차 제출한 코드로 내용 변경됨ㅠㅠ(단, GitHub에서 commit history 보면 내가 처음 제출/통과한 코드 볼 수는 있음)
        for(int i=0; i<ingredient.length-3; i++){
            if(ingredient[i]==0) continue;
            if(ingredient[i]==1&&ingredient[i+1]==2&&ingredient[i+2]==3&&ingredient[i+3]==1){
                for(int j=i+3; j>0;j--){
                    ingredient[j] = (j>3) ? ingredient[j-4] : 0;    
                }
                answer++;    
            }
        }        
        
        return answer;
    }
}