package 프로그래머스.lv1.q12901;

class SolutionV2 {
    // 2022.11.16(수) 0h10
    public String solution(int a, int b) {
        int[] numOfDaysInMonth = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int nThDay = 0;
        int numOfDaysInPreviousMonths = 0;

        if (a > 1) {
            for (int i = 0; i <= a - 2; i++) {
                numOfDaysInPreviousMonths += numOfDaysInMonth[i];
            }

            nThDay = numOfDaysInPreviousMonths + b;
        } else {
            nThDay = b;
        }
        // nThDay = a > 1 ? (a - 1) * daysInMonth[a - 2] + b : b;

        String[] daysOfWeek = new String[]{"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        return daysOfWeek[nThDay % 7];
    }
}