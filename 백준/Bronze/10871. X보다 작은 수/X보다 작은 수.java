import java.io.*;
import java.util.Arrays;

// 2022.12.3(토) 10h25 -> 10h40 제출 시 number format 런타임 에러(지난 번과 같은 오류)
public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 런타임 오류 해결을 위한 수정/추가
        String[] strs1 = br.readLine().split(" ");
        int N = Integer.parseInt(strs1[0]); // 주어지는 수들의 총 개수
        int X = Integer.parseInt(strs1[1]); // 크기 비교 대상

        String[] strs2 = br.readLine().split(" ");

        int[] nums = new int[N];

        // 입력 2번째 줄에 주어진 수들을 하나씩 배열 nums에 담음
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(strs2[i]); // 10h35 테스트 시 이 라인 좌변을 nums[0]으로 써놔서 제대로 동작 안 했음
        }

        // 별도의 메서드에서 문제 요구사항/로직 처리

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(getSmallerNumbersThanX(nums, X)); // 1 4 2 3

        br.close();
        bw.flush();
        bw.close();
    }

    public static String getSmallerNumbersThanX(int[] nums, int X) {
        String result = "";

        for (int num : nums) {
            if (num < X) result = result + num + " ";
        }
        
        return result;
    }
}
