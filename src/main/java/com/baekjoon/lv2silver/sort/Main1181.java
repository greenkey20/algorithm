package com.baekjoon.lv2silver.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 2022.12.31(토) 22h55 -> 아래 버전(입/출력 예시는 맞는 것 같은데) 23h30 제출 시 틀렸는데, 왜 틀렸는지 잘 모르겠음
// 2023.4.13(목) 21h30 ~ 21h55 v2 여전히 틀렸습니다 = why 잘 모르겠음
// references = https://infodon.tistory.com/51, https://st-lab.tistory.com/112
public class Main1181 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N = 정렬 대상 단어의 개수
        // v1
//        Set<String> inputs = new HashSet<>(N);
        // 2023.4.13(목) 21h35 v2
        String[] inputs = new String[N];

        for (int i = 0; i < N; i++) {
//            inputs.add(br.readLine());
            inputs[i] = br.readLine();
        }

        // 문제 해결 로직
        inputs = sortWordsWithComparator(inputs);

        // 출력
        StringBuilder sb = new StringBuilder();

        // v1
        /*
        for (String word : sortWords(inputs)) {
            sb.append(word).append("\n");
        }
         */
        // v2 정렬된 상태로 반환받은 inputs 원소들 중 중복된 단어는 하나만 남기고 제거해야 함
        for (int i = 0; i < N - 1; i++) {
            if (!inputs[i].equals(inputs[i + 1])) {
                sb.append(inputs[i]).append("\n");
            }
        }

        if (!inputs[N - 2].equals(inputs[N - 1])) {
            sb.append(inputs[N - 1]);
        }

        System.out.println(sb);
    }

    public static List<String> sortWords(Set<String> inputs) {
        TreeSet<String> lengthAndInputs = new TreeSet<>();

        // 2023.4.13(목) 21h5 작년에 작성한 코드 점검
        // IntelliJ가 while문으로부터 for문으로 바꿔준 것 >.<
        for (String input : inputs) {
            String lengthAndInput = input.length() + "/" + input; // 정렬 대상 단어들은 알파벳 소문자로 이루어져 있으므로, 특수 기호를 구분자로 사용 가능
            lengthAndInputs.add(lengthAndInput);
        }
        /*
        while (it1.hasNext()) {
            String input = it1.next();
            String lengthAndInput = input.length() + input;
            lengthAndInputs.add(lengthAndInput);
        }
         */

        Iterator<String> it2 = lengthAndInputs.iterator();
        List<String> words = new ArrayList<>();

        while (it2.hasNext()) {
//            String word = it2.next().substring(1); // 2023.4.13(목) 21h8 나의 생각 = input의 길이가 1자리 숫자가 아닐 수도 있기 때문에(주어지는 단어 input의 개수는 최대 20,000개) 이렇게 substring() 하면 안 됨
            String word = it2.next().split("/")[1]; // 2023.4.13(목) 21h15 입/출력 예시로는 의도하는대로 동작하는 것 같은데 '틀렸습니다' -> 검색해 봄
            words.add(word);
        }

        return words;
    }

    public static String[] sortWordsWithComparator(String[] inputs) {
        Arrays.sort(inputs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        return inputs;
    }
}
