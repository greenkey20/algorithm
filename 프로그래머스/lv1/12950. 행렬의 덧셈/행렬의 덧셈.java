class Solution {
    // 2023.1.7(토) 17h25
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int lengthOfArr = arr1.length;
        int lengthOfInnerArr = arr1[0].length;
        
        int[][] answer = new int[lengthOfArr][lengthOfInnerArr];
        
        for (int i = 0; i < lengthOfArr; i++) {
            for (int j = 0; j < lengthOfInnerArr; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }   
        
        return answer;
    }
}