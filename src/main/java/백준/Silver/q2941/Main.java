package 백준.Silver.q2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

// 2022.12.14(수) 13h50 v1 제대로 동작 안 함, 테스트케이스들 종이에 써가며 더 정교하게 짜보자.. -> 2022.12.15(목) 2h25 다시 시도했으나, 잘 모르겠음 -> 2h55 검색해보기로 함 -> 3h
public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        // 문제 해결 로직

        // 출력
        System.out.println(countCroatianAlphabets(word));
    }

    public static int countCroatianAlphabets(String word) {
        List<String> croatianAlphabets = List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

        for (int i = 0; i < croatianAlphabets.size(); i++) {
            String str = croatianAlphabets.get(i);

            if (word.indexOf(str) != -1) {
                word = word.replace(str, "*");
            }           
        }

        return word.length();
    }
}