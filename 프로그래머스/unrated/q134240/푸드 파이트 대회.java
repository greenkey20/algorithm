class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int quantityOfFood = food[i];

            for (int j = 0; j < quantityOfFood / 2; j++) {
                sb.append(i);
            }
        }

        String competitorOne = sb.toString();

        sb.append("0");

        for (int i = competitorOne.length() - 1; i >= 0; i--) {
            sb.append(competitorOne.charAt(i));
        }

        return sb.toString();
    }
}