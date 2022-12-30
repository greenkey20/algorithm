package com.programmers.lv1;

import java.util.*;

// 2022.11.27(일) 0h50
public class SortStrings {
    public String[] solution(String[] strings, int n) {
        /*
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("o1 = " + o1 + ", o2 = " + o2);
                char c1 = o1.charAt(n);
                char c2 = o2.charAt(n);
                System.out.println("c1 = " + c1 + ", c2 = " + c2 + ", c1 < c2 = " + (c1 < c2));

                if (c1 < c2) return -1; // 2022.11.27(일) 23h50 제출 시 입/출력 예시는 통과하나, 테스트케이스1만 통과 + 테스트케이스2~12 실패
                else if (c1 == c2) return o1.compareTo(o2);
                else return o1.compareTo(o2);
            }
        });
         */

        // 2022.11.27(일) 23h50 v3 Arrays.sort() 오버라이딩 말고, 로직 한 줄 한 줄 구현해보자 -> 2022.11.28(월) 0h20 제출/테스트해 보니, 중복 값이 list에 담길 수 있음(입/출력예시1 ["car","bed","car","sun"], 2 ["abcd","abce","abce","cdx"])을 내가 충분히 고민하지 않았음을 알게 됨
        // '질문하기' 잠깐 훑어보고 얻은 아이디어 = strings 배열을 sort한 다음, n번째 글자 비교해서 정렬 수정
        Arrays.sort(strings); // strings 배열의 원소들을 오름차순으로 정렬해둠
//        String[] answer = new String[strings.length];

        /*
        List<String> answerList = new ArrayList<>();

        for (int i = 0; i < strings.length - 1; i++) {
            String o1 = strings[i];
            String o2 = strings[i + 1];

            char c1 = o1.charAt(n);
            char c2 = o2.charAt(n);

            if (c1 > c2) {
                answerList.add(o2);
                answerList.add(o1);
            } else {
                answerList.add(o1);
                answerList.add(o2);
            }
        }

        return answerList.toArray(new String[strings.length]);
         */

        // 2022.11.28(월) 0h35 v4 아이디어 다시 정리해서 다시 코딩
        // map 하나 만들어서 오름차순 순서(key)-strings[i] 원소의 n번째 글자(value)를 담아둠
        Map<Integer, Character> nMap = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            nMap.put(i, strings[i].charAt(n));
//            System.out.println(nMap);
        }

        // map의 key-value 쌍을 list로 만듦 -> value 값의 오름차순으로 정렬
        // google "자바 map 정렬" -> https://ponyozzang.tistory.com/404 문법 및 코드 참고
        List<Map.Entry<Integer, Character>> listEntries = new ArrayList<>(nMap.entrySet());
//        System.out.println(listEntries); // [0=e, 1=a, 2=u]

        Collections.sort(listEntries, new Comparator<Map.Entry<Integer, Character>>() {
            @Override
            public int compare(Map.Entry<Integer, Character> o1, Map.Entry<Integer, Character> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
//        System.out.println(listEntries); // [1=a, 0=e, 2=u]

        // 이 메서드의 반환 자료(String 배열) 변수 하나 만듦
        String[] answer = new String[strings.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = strings[listEntries.get(i).getKey()]; // n번째 글자의 오름차순으로 정렬된 listEntries의 key 값 = strings 배열에서의 위치/인덱스 -> listEntries가 정렬된 순서대로 strings 배열에서 단어 꺼내서 answer 정렬에 담음
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] output = new SortStrings().solution(new String[]{"sun", "bed", "car"}, 1);
        System.out.println(Arrays.toString(output)); // ["car", "bed", "sun"] vs 1h10 v1 및 v2 실행 결과 = [bed, car, sun] -> 2022.11.27(일) 23h20 debugging 해보고, 로그 찍어보지만, 내가 쓴 오버라이딩한 sort() 동작 원리 잘 모르겠음

        output = new SortStrings().solution(new String[]{"abce", "abcd", "cdx"}, 2);
        System.out.println(Arrays.toString(output)); // [abcd, abce, cdx]
    }

    /* 회고
    1. 몸과 마음이 피곤한/약한 상태에서 + 입/출력 예시가 간단한 사례라서 깊은 고민을 안 하고 좀 무작정 코딩을 했다 vs 겸손하되, 긍정적/적극적 태도를 가지고, 문제에 한 단계씩 차분하게 접근하자, please T.T
    2. '질문하기' 게시판에서 힌트 얻기, 구글링('java 문제명') 찬스를 중간중간 2번 썼다 -> 구글링 결과(reference1)를 보고 그냥 따라서 칠까 하다가, 내 나름대로 조금 더 고민해서 구현하고 통과해서(v4) 뿌듯하다
    3. Comparator를 실제로 처음 써 보게 되었는데, 유용한 것 같지만, 아직 공부를 많이 한 게 아니라서 코드 및 동작 이해 못했다
    4. reference1 = n번째 글자를 strings 요소의 맨 앞에 붙여서 정렬 + 맨 앞에 붙인 그 n번째 글자를 떼서 answer 배열 만들기
    5. reference2 = 나의 v1/2와 같이 Arrays.sort() 재정의
    6. reference3 = Stream API 활용
     */

    public String[] solutionReference1(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }
        return answer;
    }

    public String[] solutionReference2(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.charAt(n) > s2.charAt(n)) return 1;
                else if (s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                else if (s1.charAt(n) < s2.charAt(n)) return -1;
                else return 0;
            }
        });
        return strings;
    }

    public String[] solutionReference3(String[] strings, int n) {
        return Arrays.stream(strings).map(string -> new IndexString(string, n)).sorted()
                .map(indexString -> indexString.string).toArray(String[]::new);
    }

    class IndexString implements Comparable<IndexString> {
        String string;
        char index;

        IndexString(String string, int index) {
            this.string = string;
            this.index = string.charAt(index);
        }

        public int compareTo(IndexString indexString) {
            System.out.println(index + "," + indexString.index);
            if (index == indexString.index) {
                return string.compareTo(indexString.string);
            } else {
                return index - indexString.index;
            }
        }
    }
}
