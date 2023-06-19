import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 2023.6.19(월) 23h50 ~ 2023.6.20(화) 0h35 v1
public class Main {
    private static List<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 ≤ N ≤ 10,000

        List<String> commands = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            commands.add(command);
        }

        // 문제 해결 로직
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);
            int result = 0;

            if (command.equals("pop")) {
//                System.out.println("pop 명령을 수행합니다"); // todo
                result = pop();
                sb.append(result).append("\n");
            } else if (command.equals("size")) {
//                System.out.println("size 명령을 수행합니다"); // todo
                result = size();
                sb.append(result).append("\n");
            } else if (command.equals("empty")) {
//                System.out.println("empty 명령을 수행합니다"); // todo
                result = empty();
                sb.append(result).append("\n");
            } else if (command.equals("top")) {
//                System.out.println("top 명령을 수행합니다"); // todo
                result = top();
                sb.append(result).append("\n");
            } else { // command.contains("push")
//                System.out.println("push 명령을 수행합니다"); // todo
                push(Integer.parseInt(command.split(" ")[1]));
            }
        }

        // 결과 출력
        System.out.print(sb);
    }

    public static int pop() {
        if (empty() == 1) { // 스택이 비어있으면
            return -1;
        }

        // 스택이 비어있지 않으면
        int element = stack.get(size() - 1);
        stack.remove(size() - 1); // 스택에서 가장 위에 있는 정수를 뺌/삭제
        return element; // 스택에서 가장 위에 있던 정수를 반환
    }

    public static int size() {
        int result = 0;

        for (int element : stack) {
            result++;
        }

        return result;
    }

    // 스택이 비어있으면 = 원소의 수가 0이면 1 vs 스택이 비어있지 않으면 0 반환
    public static int empty() {
        return size() == 0 ? 1 : 0;
    }

    public static int top() {
        if (empty() == 1) { // 스택이 비어있으면
            return -1;
        }

        // 스택이 비어있지 않으면 스택에서 가장 위에 있는 정수를 반환
        return stack.get(size() - 1);
    }

    public static void push(int element) {
        stack.add(element);
    }
}
