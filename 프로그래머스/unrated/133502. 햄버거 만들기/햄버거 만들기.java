class Solution {
    public int solution(int[] ingredients) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ingredients.length; i++) {
            sb.append(ingredients[i]);

            if (sb.length()  >= 4 && sb.substring(sb.length() - 4, sb.length()).equals("1231")) {
                answer++;
                sb.delete(sb.length() - 4, sb.length());
            }
        }
        
        return answer;
    }
}