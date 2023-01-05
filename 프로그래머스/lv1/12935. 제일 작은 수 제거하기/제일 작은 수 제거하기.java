class Solution {
    // 2023.1.6(금) 7h20
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};
        
        int min = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        
        int[] answer = new int[arr.length - 1];
        int idx = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int thisNum = arr[i];
            
            if (thisNum != min) {
                answer[idx] = thisNum;
                idx++;
            }
        }
        
        return answer;
    }
}