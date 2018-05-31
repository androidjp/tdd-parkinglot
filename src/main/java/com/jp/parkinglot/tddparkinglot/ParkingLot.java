package com.jp.parkinglot.tddparkinglot;

import com.jp.parkinglot.tddparkinglot.bean.Car;
import com.jp.parkinglot.tddparkinglot.bean.CarTicket;
import com.jp.parkinglot.tddparkinglot.exception.CarNotFoundException;
import com.jp.parkinglot.tddparkinglot.exception.ParkingLotFilledException;

import java.util.HashMap;
import java.util.Map;

/**
 * User: androidjp
 * Date: 2018/5/26
 * Time: 下午11:13
 * Description:
 */
public class ParkingLot implements Parkable {
    private final int parkingRoomCount;
    private Map<CarTicket, Car> parkedCarMap;
    private int curTicketNum;

    public ParkingLot(int parkingRoomCount) {
        this.parkingRoomCount = parkingRoomCount;
        this.parkedCarMap = new HashMap<>();
        this.curTicketNum = 100;
    }

    @Override
    public int getAvailableRoom() {
        return this.parkingRoomCount - this.parkedCarMap.size();
    }

    @Override
    public CarTicket park(Car car) throws ParkingLotFilledException {
        if (this.getAvailableRoom() <= 0) {
            throw new ParkingLotFilledException();
        }
        CarTicket carTicket = new CarTicket(this.curTicketNum++);
        this.parkedCarMap.put(carTicket, car);
        return carTicket;
    }

    @Override
    public Car pickUp(CarTicket ticket) {
        if (hasCar(ticket)) {
            return this.parkedCarMap.remove(ticket);
        } else {
            throw new CarNotFoundException();
        }
    }

    @Override
    public boolean hasCar(CarTicket carTicket) {
        return this.parkedCarMap.containsKey(carTicket);
    }

    public double getAvailableRoomRate() {/////
        return this.getAvailableRoom()*1.0 / this.parkingRoomCount;
    }
}
