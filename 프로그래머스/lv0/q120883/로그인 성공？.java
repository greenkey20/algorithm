package 프로그래머스.lv0.q120883;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // 2022.11.5(토) 23h35
    public String solution(String[] id_pw, String[][] db) {
        // String answer = "";
        // return answer;

        for (int i = 0; i < db.length; i++) {
            if (db[i][0].equals(id_pw[0])) {
                if (db[i][1].equals(id_pw[1])) {
                    return "login";
                } else {
                    return "wrong pw";
                }
            }
        }

        return "fail";
    }

    /* 회고
    1. 주어진 회원 정보를 'id-비밀번호' 쌍의 map으로 만든 풀이가 재미있어 보임(아래 ref1() 메서드)
    2. 문제 풀이에 지장은 없었지만, 시간이 없다는 핑계로 문제 조건들을 꼼꼼하게 읽지 않고 풀었다 vs 문제를 꼼꼼히 읽자
     */

    public String solutionRef1(String[] idPw, String[][] db) {
        return getDb(db).get(idPw[0]) != null ? getDb(db).get(idPw[0]).equals(idPw[1]) ? "login" : "wrong pw" : "fail";
    }

    private Map<String, String> getDb(String[][] db) {
        Map<String, String> map = new HashMap<>();

        for (String[] array : db) {
            map.put(array[0], array[1]);
        }
        return map;
    }
}

