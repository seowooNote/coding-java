package com.seowoo.java;

import java.util.Scanner;

public class FibonacciV2 {
    static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("수열 개수를 입력하세요 : ");
        int num = scanner.nextInt();
        scanner.close(); // 사용하면 최대한 빨리 닫아 줍니다
        return num;
    }

    public static void main(String[] args) {
        System.out.println("피보나치 수열 만들기");

        int num = getUserInput();

        int a = 1;
        int b = 1;

        int[] fibonacci = new int[num];
        fibonacci[0] = a;
        fibonacci[1] = b;
        for(int i = 0; i < num - 2; i++) {
            fibonacci[i+2] = a + b;
            a = b;
            b = fibonacci[i+2];
        }

        System.out.println("결과: ");
        for(int i = 0; i < num; i++) {
            System.out.println(fibonacci[i]);
        }
    }
}
