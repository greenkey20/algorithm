package com.programmers.lv1;

// 2023.3.29(수) 20h ~ 20h10 v1 문제도 정확히 이해 못 했었고, 구현도 잘못했다..
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
//        int profit = 0;
        int maxPrice = 0;
        int minPrice = prices[0];

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            if (price > maxPrice) {
                maxPrice = price;
            }

            if (price < minPrice) {
                minPrice = price;
            }
        }

        if (maxPrice == prices[0]) {
            maxPrice = 0;

            for (int i = 1; i < prices.length; i++) {
                int price = prices[i];

                if (price > maxPrice) {
                    maxPrice = price;
                }
            }
        }

        return maxPrice - minPrice;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1})); // 0
    }
}
