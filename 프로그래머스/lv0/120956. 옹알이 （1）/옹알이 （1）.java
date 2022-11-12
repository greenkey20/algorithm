class Solution {
    // 2022.11.12(토) 23h50 v1 = 문제에서 의도한 바를 구현하지 못했으므로, 실패
    public int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            // 예시1 = ^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$
            // 예시2 = (aya|ye|woo|ma)+
            if (babbling[i].matches("^(aya|ye|woo|ma)+$")) answer++;
        }
        return answer;
    }
}