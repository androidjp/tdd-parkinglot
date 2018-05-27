package com.jp.parkinglot.tddparkinglot;

import com.jp.parkinglot.tddparkinglot.bean.Car;
import com.jp.parkinglot.tddparkinglot.bean.CarTicket;
import com.jp.parkinglot.tddparkinglot.exception.CarNotFoundException;
import com.jp.parkinglot.tddparkinglot.exception.ParkingLotFilledException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * User: androidjp
 * Date: 2018/5/27
 * Time: 下午7:21
 * Description:
 */
public class ParkingBoyTest {

    @Test
    public void should_park_the_cars_in_order_of_parkingLot() throws ParkingLotFilledException {
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot p1 = new ParkingLot(2);
        ParkingLot p2 = new ParkingLot(2);
        parkingLots.add(p1);
        parkingLots.add(p2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");

        assertEquals(2, p1.getAvailableCount());
        assertEquals(2, p2.getAvailableCount());

        CarTicket ticketA = parkingBoy.park(carA);
        assertEquals(1, p1.getAvailableCount());
        assertEquals(2, p2.getAvailableCount());

        CarTicket ticketB = parkingBoy.park(carB);
        CarTicket ticketC = parkingBoy.park(carC);

        assertEquals(0, p1.getAvailableCount());
        assertEquals(1, p2.getAvailableCount());

        parkingBoy.pickUp(ticketB);
        assertEquals(1, p1.getAvailableCount());
        assertEquals(1, p2.getAvailableCount());

        parkingBoy.park(new Car("D"));
        assertEquals(0, p1.getAvailableCount());
        assertEquals(1, p2.getAvailableCount());
    }

    @Test(expected = CarNotFoundException.class)
    public void should_throw_exception_when_pickUp_a_car_is_not_existed() throws ParkingLotFilledException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot p1 = new ParkingLot(2);
        parkingLots.add(p1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car carA = new Car("A");
        CarTicket ticketA = parkingBoy.park(carA);
        //when
        parkingBoy.pickUp(ticketA);
        parkingBoy.pickUp(ticketA);
        //then
    }

    @Test(expected = ParkingLotFilledException.class)
    public void should_throw_exception_when_park_a_car_after_all_parkingLots_are_filled() throws ParkingLotFilledException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot p1 = new ParkingLot(1);
        ParkingLot p2 = new ParkingLot(2);
        parkingLots.add(p1);
        parkingLots.add(p2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(new Car("A"));
        parkingBoy.park(new Car("B"));
        parkingBoy.park(new Car("C"));

        //when
        parkingBoy.park(new Car("D"));

        //then
    }
}
