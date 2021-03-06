package com.jp.parkinglot.tddparkinglot;

import com.jp.parkinglot.tddparkinglot.bean.Car;
import com.jp.parkinglot.tddparkinglot.bean.CarTicket;
import com.jp.parkinglot.tddparkinglot.exception.ParkingLotFilledException;

import java.util.Comparator;
import java.util.List;

/**
 * User: androidjp
 * Date: 2018/5/27
 * Time: 下午10:26
 * Description:
 */
public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public CarTicket park(Car car) throws ParkingLotFilledException {
        return parkingLots.stream()
                .max(Comparator.comparingInt(ParkingLot::getAvailableRoom))
                .orElse(parkingLots.get(0))
                .park(car);
    }
}
