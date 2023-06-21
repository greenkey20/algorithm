import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 2023.6.21(수) 0h50 ~
/* Parenthesis String(PS) -> Valid PS(VPS)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // 문제 해결 로직
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String ps = br.readLine();
//            System.out.println(i + 1 + "번째 ps = " + ps); // todo

            sb.append(isVps(ps)).append("\n");
        }

        // 결과 출력
        System.out.print(sb);
    }

    /*
    public static String isVps(String ps) {
        String result = "";

        List<String> leftParenthesis = new ArrayList<>(); // ( 괄호를 쌓아둘 스택
        List<String> rightParenthesis = new ArrayList<>(); // ) 괄호를 쌓아둘 스택

        for (int i = 0; i < ps.length(); i++) {
            String p = String.valueOf(ps.charAt(i));

            if (p.equals("(")) {
                leftParenthesis.add(p);
            } else {
                rightParenthesis.add(p);
            }
        }

        for (int i = 0; i < ps.length(); i++) {

        }
        return result;
    }
     */

    // 2023.6.21(수) 1h15 연습장 + 연필로 생각 정리하다가 써봄
    public static String isVps(String ps) {
        StringBuilder sb = new StringBuilder();

        for (int i = ps.length() - 1; i >= 0; i--) {
            String ch = String.valueOf(ps.charAt(i));
            sb.insert(0, ch);

//            System.out.println("[before \"if\"] currentString = " + sb); // todo

            if (String.valueOf(sb).startsWith("()")) {
                sb.replace(0, 2, "");
            }
//            System.out.println("[after \"if\"] currentString = " + sb); // todo
        }

        if (String.valueOf(sb).length() != 0) {
            return "NO";
        }

        return "YES";
    }
}
