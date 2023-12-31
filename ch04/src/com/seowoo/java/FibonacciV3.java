package com.seowoo.java;

import java.util.Scanner;

public class FibonacciV3 {
    static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("수열 개수를 입력하세요 : ");
        int num = scanner.nextInt();
        scanner.close();
        return num;
    }

    static void getFibonacci(int fibonacci[]) {
        int a = 1;
        int b = 1;

        int num = fibonacci.length;
        fibonacci[0] = a;
        fibonacci[1] = b;
        for(int i = 0; i < num - 2; i++) {
            fibonacci[i+2] = a + b;
            a = b;
            b = fibonacci[i+2];
        }
    }

    public static void main(String[] args) {
        System.out.println("피보나치 수열 만들기");

        int num = getUserInput();

        int[] fibonacci = new int[num];
        getFibonacci(fibonacci);

        System.out.println("결과: ");
        for(int i = 0; i < num; i++) {
            System.out.println(fibonacci[i]);
        }
    }
}
