class Solution {
    public int solution(int[][] sizes) {
        for (int i = 0; i < sizes.length; i++) {
            int left = sizes[i][0];
            int right = sizes[i][1];

            if (left < right) {
                int temp = left;
                sizes[i][0] = right;
                sizes[i][1] = temp;
            }
        }

        int maxLeft = 0;
        int maxRight = 0;

        for (int i = 0; i < sizes.length; i++) {
            int left = sizes[i][0];
            int right = sizes[i][1];

            if (left > maxLeft) {
                maxLeft = left;
            }

            if (right > maxRight) {
                maxRight = right;
            }
        }

        return maxLeft * maxRight;
    }
}