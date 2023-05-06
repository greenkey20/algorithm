import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2023.5.5(금) 22h20 ~ 22h45 뼈대만 작성
/* 문제 읽고 종이에 써보며 어떻게 풀어야 할지 생각해봄
2023.5.6(토) 22h20 ~ 22h45 v1 작성해서 입/출력 예시 돌려보니 의도하는 답이 나옴
 */
public class Main {
    public static int cntOfWhites; // 0이 써져있는 + 크기는 2^0 ~ 2^7 중 하나인 색종이
    public static int cntOfBlues; // 1이 써져있는 + 크기는 2^0 ~ 2^7 중 하나인 색종이

    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] totalPapers = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] thisLine = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                totalPapers[i][j] = Integer.parseInt(thisLine[j]);
            }
        }
//        StringTokenizer st = new StringTokenizer(br.readLine(), "\t\n\r\f");

        //System.out.println("n = " + n + ", 색종이 전체 = " + Arrays.deepToString(totalPapers)); // todo

        // 문제 풀이 로직
        divideAndConquer(totalPapers);

        // 결과 출력
        System.out.println(cntOfWhites);
        System.out.println(cntOfBlues);
    }

    public static void divideAndConquer(int[][] papers) {

        // 문제가 더 이상 쪼개질 수 없을 때
        if (papers.length == 1) {
            if (papers[0][0] == 1) {
                cntOfBlues++;
                return;
            } else {
                cntOfWhites++;
                return;
            }
        }

        int sum = 0;
        // 문제가 더 작은 단위로 쪼개질 수 있을 때
        for (int i = 0; i < papers.length; i++) {
            // 무엇을 어떻게 구현해야 할까
            for (int j = 0; j < papers.length; j++) {
                sum += papers[i][j];
            }
        }

        if (sum == Math.pow(papers.length, 2)) {
            cntOfBlues++;
            return;
        } else if (sum == 0) {
            cntOfWhites++;
            return;
        } else {
            int[][] half1 = new int[papers.length / 2][papers.length / 2];
            for (int i = 0; i < half1.length; i++) {
                for (int j = 0; j < half1.length; j++) {
                    half1[i][j] = papers[i][j];
                }
            }
            divideAndConquer(half1);

            int[][] half2 = new int[papers.length / 2][papers.length / 2];
            for (int i = 0; i < half2.length; i++) {
                for (int j = papers.length / 2; j < papers.length; j++) {
                    half2[i][j - papers.length / 2] = papers[i][j];
                }
            }
            divideAndConquer(half2);

            int[][] half3 = new int[papers.length / 2][papers.length / 2];
            for (int i = papers.length / 2; i < papers.length; i++) {
                for (int j = 0; j < half1.length; j++) {
                    half3[i - papers.length / 2][j] = papers[i][j];
                }
            }
            divideAndConquer(half3);

            int[][] half4 = new int[papers.length / 2][papers.length / 2];
            for (int i = papers.length / 2; i < papers.length; i++) {
                for (int j = papers.length / 2; j < papers.length; j++) {
                    half4[i - papers.length / 2][j - papers.length / 2] = papers[i][j];
                }
            }
            divideAndConquer(half4);
        }
    }
}
