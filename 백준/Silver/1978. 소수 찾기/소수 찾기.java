import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int[] inputs = new int[n];

        for (int i = 0; i < n; i++) {
            inputs[i] = sc.nextInt();
        }

        int count = 0;
        
        for (int i = 0; i < n; i++) {
            boolean isPrime = true;
            
            if (inputs[i] == 1) {
                continue; // unnecessary as the last statement in a loop
            } else if (inputs[i] == 2) {
                count++;
            } else if (inputs[i] % 2 == 0) {
                continue;
            } else {
                for (int j = 3; j <= Math.sqrt(inputs[i]); j += 2) {
                    if (inputs[i] % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

//                isPrime = true;
                if (isPrime) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}