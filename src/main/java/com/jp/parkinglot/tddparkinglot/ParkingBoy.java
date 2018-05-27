package com.jp.parkinglot.tddparkinglot;

import com.jp.parkinglot.tddparkinglot.bean.Car;
import com.jp.parkinglot.tddparkinglot.bean.CarTicket;
import com.jp.parkinglot.tddparkinglot.exception.CarNotFoundException;
import com.jp.parkinglot.tddparkinglot.exception.ParkingLotFilledException;

import java.util.List;

/**
 * User: androidjp
 * Date: 2018/5/27
 * Time: 下午7:33
 * Description:
 */
public class ParkingBoy {
    private final List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public CarTicket park(Car car) throws ParkingLotFilledException {
        for (ParkingLot parkingLot:this.parkingLots){
            if (parkingLot.getAvailableCount()>0){
                return parkingLot.park(car);
            }
        }
        return null;
    }


    public Car pickUp(CarTicket ticket) {
        for (ParkingLot parkingLot: this.parkingLots) {
            try {
                Car car = parkingLot.pickUp(ticket);
                return car;
            }catch (RuntimeException e){

            }
        }
        throw new CarNotFoundException();
    }
}
