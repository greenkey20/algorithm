import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2023.4.18(화) 23h45 ~ 23h59 v1 입/출력예시에서는 의도한대로 동작함 + 맞았습니다
// 2분탐색 가장 기본적인 문제
// 관련 학습 reference = https://st-lab.tistory.com/261
public class Main {
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 탐색 대상 = n개의 정수

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        int m = Integer.parseInt(br.readLine()); // arr에 존재하는지 검사할 수들의 개수 = m

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] numsToCheck = new int[m];
        for (int i = 0; i < m; i++) {
            numsToCheck[i] = Integer.parseInt(st2.nextToken());
        }

        // 문제 해결 로직
        Arrays.sort(arr); // 2분탐색 대상 데이터는 정렬되어있어야 함

        StringBuilder sb = new StringBuilder();

        // numsToCheck 배열의 원소를 하나하나 체크하며 2분탐색 수행
        for (int i = 0; i < m; i++) {
            int numToCheck = numsToCheck[i];
            int searchResult = binarySearch(arr, numToCheck);

            if (searchResult >= 0) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb);
    }

    public static int binarySearch(int[] arr, int numToCheck) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (numToCheck < arr[mid]) {
                right = mid - 1;
            } else if (numToCheck > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
