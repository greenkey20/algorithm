package com.baekjoon.lv1bronze.control;

import java.util.Scanner;

// 2022.4.21(목) 22h40 별 찍기2 -> 23h5 364ms 맞았습니다
public class Main_2439 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int layer = sc.nextInt();

        for (int i = 0; i < layer; i++) {
            for (int j = 0; j < layer - i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

}
