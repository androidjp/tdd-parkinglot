package com.jp.parkinglot.tddparkinglot;

import com.jp.parkinglot.tddparkinglot.bean.Car;
import com.jp.parkinglot.tddparkinglot.bean.CarTicket;
import com.jp.parkinglot.tddparkinglot.exception.ParkingLotFilledException;

/**
 * User: androidjp
 * Date: 2018/5/27
 * Time: 下午9:59
 * Description:
 */
public interface Parkable {
    int getAvailableRoom();

    CarTicket park(Car car) throws ParkingLotFilledException;

    Car pickUp(CarTicket ticket);

    boolean hasCar(CarTicket carTicket);
}
