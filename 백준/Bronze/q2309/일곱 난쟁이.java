import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // v2
    static int n = 9, r = 7, k = 100;
    static int[] dwarfs = new int[n];
    static int[] realDwarfs = new int[r];
    static int[] results = new int[r];
    static boolean ckEnd = false;

    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }

        // 문제 해결 로직
        Arrays.sort(dwarfs);

        // v2
        combination(0, 0, 0);

        // 출력
        for (int i : results) {
            System.out.println(i);
        }
    }

    // v2
    public static void combination(int count, int start, int sum) {
        // 합이 100인 7명 난쟁이를 찾았으니까, 더 이상 진행할 필요 없음
        if (ckEnd) return;

        if (count == r) { // 7명을 뽑은 조합이 되었고
            if (sum == k) { // 7명의 키의 합이 100이면
                // 이 조합을 '답'으로 적어둠
                // Manual array copy = 내가 작성한 것
                /*
                for (int i = 0; i < realMembers.length; i++) {
                    results[i] = realMembers[i];
                }
                 */
                // IntelliJ의 suggestion
                System.arraycopy(realDwarfs, 0, results, 0, realDwarfs.length);

                ckEnd = true;
            }
            return;
        }

        for (int i = start; i < dwarfs.length; i++) {
            realDwarfs[count] = dwarfs[i];
            combination(count + 1, i + 1, sum + dwarfs[i]);
        }
    }
}