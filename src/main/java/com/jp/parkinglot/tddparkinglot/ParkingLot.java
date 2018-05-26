package com.jp.parkinglot.tddparkinglot;

import java.util.ArrayList;
import java.util.List;

/**
 * User: androidjp
 * Date: 2018/5/26
 * Time: 下午11:13
 * Description:
 */
public class ParkingLot {
    private final int parkingRoomCount;
    private List<Car> carList;
    public ParkingLot(int parkingRoomCount) {
        this.parkingRoomCount = parkingRoomCount;
        this.carList = new ArrayList<>();
    }

    public int getAvailableCount() {
        return this.parkingRoomCount - this.carList.size();
    }

    public void park(Car car) {
        this.carList.add(car);
    }
}
