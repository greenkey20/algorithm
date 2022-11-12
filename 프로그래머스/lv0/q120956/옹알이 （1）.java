package 프로그래머스.lv0.q120956;

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

    /* 회고
    1. lv0라서 쉽게 생각했는데, 생각보다 고민도, 시도도 많이 해야 했다.. 앞으로 문제 풀 때도 겸손한 태도로 차근차근 접근하자
    2. 람다, 메서드 참조, 스트림, 아직 완벽하게 알지 못하고 능숙하게 사용하지 못하지만, 오늘 조금이나마 더 연습하고 시도하고 고민해본다
    3. 문제 풀이 과정에서 별도 Java 파일로 만들어서 versions 및 메모해 두었다
     */
}