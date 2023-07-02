import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 2023.7.1(토) 14h50 휴우, 9012번 문제 계속 풀다가, 잠시 두뇌 회로를 다른 곳으로 돌리고자 풀이 시작 ~ 15h5 v1
public class Main {
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도감에 수록되어있는 포켓몬의 총 개수
        int m = Integer.parseInt(st.nextToken()); // 내가 맞춰야 하는 문제의 개수

        Map<Integer, String> pokemonsNumAndName = new HashMap<>();
        Map<String, Integer> pokemonsNameAndNum = new HashMap<>();

        // 문제 해결 로직
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            int index = i + 1;
            pokemonsNumAndName.put(index, input);
            pokemonsNameAndNum.put(input, index);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            char firstCh = input.charAt(0);
            String searchResult = "";

            if (Character.isDigit(firstCh)) { // 맞춰야 하는 문제의 첫번째 글자가 숫자인 경우
                searchResult = pokemonsNumAndName.get(Integer.parseInt(input)); // 해당 숫자에 해당하는 포켓몬 이름 찾기
            } else { // 맞춰야 하는 문제의 첫번째 글자가 문자인 경우 = 숫자가 아닌 경우
                searchResult = String.valueOf(pokemonsNameAndNum.get(input));
            }

            sb.append(searchResult).append("\n");
        }

        // 결과 출력
        System.out.print(sb);
    }
}
