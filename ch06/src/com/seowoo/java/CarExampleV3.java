package com.seowoo.java;

class MyCar implements Car {
    private static final int DEFAULT_ACCEL = 10;
    private static final String SPEED_UNIT = "km/h";

    // 멤버 변수
    private String carNumber;
    private int speed = 0;

    // 생성자
    public MyCar(String carNumber) {
        this.carNumber = carNumber;
    }

    public void start() {
        System.out.println("내 차량 " + carNumber + "에 시동을 겁니다");
        accelerate();
    }
    public void accelerate() {
        accelerate(DEFAULT_ACCEL);
    }
    public void accelerate(int km) {
        speed += km;
        printSpeed(speed);
    }
    public void decelerateHalf() {
        speed *= 0.5;
        printSpeed(speed);
    }
    public void decelerateAs(int km) {
        speed -= km;
        printSpeed(speed);
    }

    private static void printSpeed(final int speed) {
        System.out.println("시속: " + speed + SPEED_UNIT);
    }
}

public class CarExampleV3 {
    public static void main(String[] args) {
        Car car = new MyCar("가1234");
        car.start();
        car.accelerate();
        car.accelerate(70);
        car.decelerateAs(60);
        car.decelerateHalf();
    }
}
