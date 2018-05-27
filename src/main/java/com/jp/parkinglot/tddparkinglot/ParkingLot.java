package com.jp.parkinglot.tddparkinglot;

import java.util.HashMap;
import java.util.Map;

/**
 * User: androidjp
 * Date: 2018/5/26
 * Time: 下午11:13
 * Description:
 */
public class ParkingLot {
    private final int parkingRoomCount;
    private Map<CarTicket, Car> parkedCarMap;
    private int curTicketNum;

    public ParkingLot(int parkingRoomCount) {
        this.parkingRoomCount = parkingRoomCount;
        this.parkedCarMap = new HashMap<>();
        this.curTicketNum = 100;
    }

    public int getAvailableCount() {
        return this.parkingRoomCount - this.parkedCarMap.size();
    }

    public CarTicket park(Car car) throws ParkingLotFilledException {
        if (this.parkingRoomCount - this.parkedCarMap.size() <= 0) {
            throw new ParkingLotFilledException();
        }
        CarTicket carTicket = new CarTicket(this.curTicketNum++);
        this.parkedCarMap.put(carTicket, car);
        return carTicket;
    }

    public Car pickUp(CarTicket ticket) {
        if (this.parkedCarMap.containsKey(ticket)) {
            return this.parkedCarMap.remove(ticket);
        } else {
            throw new CarNotFoundException();
        }
    }
}
