package com.jp.parkinglot.tddparkinglot;

import com.jp.parkinglot.tddparkinglot.bean.Car;
import com.jp.parkinglot.tddparkinglot.bean.CarTicket;
import com.jp.parkinglot.tddparkinglot.exception.ParkingLotFilledException;

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
        ParkingLot parkingLotwithMaxRoom = parkingLots.get(0);
        for (ParkingLot item: parkingLots) {
            if (parkingLotwithMaxRoom.getAvailableRoom() < item.getAvailableRoom()) {
                parkingLotwithMaxRoom = item;
            }
        }
        return parkingLotwithMaxRoom.park(car);
    }
}
