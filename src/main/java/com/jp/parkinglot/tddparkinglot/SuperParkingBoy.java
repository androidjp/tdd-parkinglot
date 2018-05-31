package com.jp.parkinglot.tddparkinglot;

import com.jp.parkinglot.tddparkinglot.bean.Car;
import com.jp.parkinglot.tddparkinglot.bean.CarTicket;
import com.jp.parkinglot.tddparkinglot.exception.ParkingLotFilledException;

import java.util.List;

/**
 * User: androidjp
 * Date: 2018/5/31
 * Time: 下午11:08
 * Description:
 */
public class SuperParkingBoy extends ParkingBoy {
    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) throws ParkingLotFilledException {
        ParkingLot maxEmptyRoomRateParkingLot = this.parkingLots.get(0);
        for (ParkingLot parkingLot : this.parkingLots) {
            if (maxEmptyRoomRateParkingLot.getAvailableRoomRate() < parkingLot.getAvailableRoomRate()) {
                maxEmptyRoomRateParkingLot = parkingLot;
            }
        }
        return maxEmptyRoomRateParkingLot.park(car);
    }
}
