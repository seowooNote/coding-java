package com.seowoo.java;

public class DoWhileBasic {
    public static void main(String[] args) {
        String[] planets = {"수성", "금성", "지구", "화성", "목성", "토성"};

        int i = 0;
        do {
            String dest = planets[i];
            System.out.println(dest + "(으)로 우주 여행을 가자!");
            i++;
        } while (i < -1);
    }
}
