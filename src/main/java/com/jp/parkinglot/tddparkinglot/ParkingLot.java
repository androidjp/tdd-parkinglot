package com.jp.parkinglot.tddparkinglot;

/**
 * User: androidjp
 * Date: 2018/5/26
 * Time: 下午11:13
 * Description:
 */
public class ParkingLot {
    private final int parkingRoomCount;

    public ParkingLot(int parkingRoomCount) {
        this.parkingRoomCount = parkingRoomCount;
    }

    public int getAvailableCount() {
        return this.parkingRoomCount;
    }
}
