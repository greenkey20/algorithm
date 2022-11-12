class Solution {
    // 2022.11.12(토) 23h50 v1 = 문제에서 의도한 바를 구현하지 못했으므로, 실패
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] replacedWords = new String[babbling.length];
        for (int i = 0; i < babbling.length; i++) {
            String toCheck = babbling[i];
            String replaced = toCheck.replace("aya", ",").replace("ye", ",").replace("woo", ",").replace("ma", ",");
            replacedWords[i] = replaced;
        }

        // 2022.11.13(일) 1h30 v3
        for (int i = 0; i < replacedWords.length; i++) {
            String toCheck = replacedWords[i];
            if (!toCheck.chars().anyMatch(ch -> Character.isLetter(ch))) answer++;
        }
        
        return answer;
    }
}