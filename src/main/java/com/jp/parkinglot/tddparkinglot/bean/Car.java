package com.jp.parkinglot.tddparkinglot.bean;

/**
 * User: androidjp
 * Date: 2018/5/26
 * Time: 下午11:27
 * Description:
 */
public class Car {
    private final String carNum;

    public Car(String carNum) {
        this.carNum = carNum;
    }

    @Override
    public boolean equals(Object obj) {
        Car other = (Car) obj;
        return this.carNum.equals(other.carNum);
    }
}
