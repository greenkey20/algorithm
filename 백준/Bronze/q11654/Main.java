package 백준.Bronze.q11654;// 2022.12.5(월) 6h10
import java.io.*;

/**
 * 알파벳 소문자, 대문자, 숫자 0-9 중 하나가 주어짐 -> 주어진 글자의 아스키 코드값을 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char ch = br.readLine().charAt(0);

        // 구현

        // 출력
        System.out.println(getAsciiCode(ch)); // 0 입력 -> 48 출력

        br.close();
    }

    // 구현
    public static int getAsciiCode(char ch) {
        int asciiCode = ch;
        return asciiCode;
    }
}
