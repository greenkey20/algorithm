package com.programmers.lv1;

public class MakePrimeNumbers {
    // 2023.1.7(토) 17h35
    public static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    boolean isPrimeNumber = true;

                    if (sum == 1) continue;
                    if (sum % 2 == 0) continue;
                    for (int l = 3; l <= Math.sqrt(sum); l++) {
                        if (sum % l == 0) {
                            isPrimeNumber = false;
                            break;
                        }
                    }

                    if (isPrimeNumber) answer++;

//                    System.out.println("nums[i] = " + nums[i] + ", nums[j] = " + nums[j] + ", nums[k] = " + nums[k] + ", sum = " + sum + ", answer = " + answer);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 7, 6, 4}));
    }
}
