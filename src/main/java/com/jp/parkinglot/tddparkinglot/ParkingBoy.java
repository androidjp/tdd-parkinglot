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
public class ParkingBoy implements Parkable {
    private final List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public CarTicket park(Car car) throws ParkingLotFilledException {
        return this.parkingLots.stream()
                .filter(parkingLot -> parkingLot.getAvailableRoom() > 0)
                .findFirst()
                .orElseThrow(ParkingLotFilledException::new)
                .park(car);
    }


    @Override
    public Car pickUp(CarTicket ticket) {
        return this.parkingLots.stream()
                .filter(parkingLot -> parkingLot.hasCar(ticket))
                .findFirst()
                .orElseThrow(CarNotFoundException::new)
                .pickUp(ticket);
    }

    @Override
    public boolean hasCar(CarTicket ticket) {
        return this.parkingLots.stream().anyMatch(parkingLot -> parkingLot.hasCar(ticket));
    }

    @Override
    public int getAvailableRoom() {
        int count = 0;
        for (ParkingLot parkingLot : parkingLots) {
            count += parkingLot.getAvailableRoom();
        }
        return count;
    }
}
