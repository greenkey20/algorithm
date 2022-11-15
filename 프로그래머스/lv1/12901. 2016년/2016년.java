import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

class Solution {
    // 2022.11.16(수) 0h10
    public String solution(int a, int b) {
        String answer = "";
        
        // google '자바 요일 구하기' 검색해서 국문 블로그 글 하나(https://hianna.tistory.com/610) skimming + Java 정석 참고
        // 단계1) LocalDate 생성
        LocalDate date = LocalDate.of(2016, a, b);
        
        // 단계2) DayOfWeek(요일) 객체 구하기
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        
        // 단계3) 단계2에서 구한 요일을 텍스트 요일로 바꾸기
        answer = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US).toString().toUpperCase();        
        
        return answer;
    }
}