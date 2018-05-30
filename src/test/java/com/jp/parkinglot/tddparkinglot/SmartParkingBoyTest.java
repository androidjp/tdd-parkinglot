package com.jp.parkinglot.tddparkinglot;

import com.jp.parkinglot.tddparkinglot.bean.Car;
import com.jp.parkinglot.tddparkinglot.exception.ParkingLotFilledException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * User: androidjp
 * Date: 2018/5/27
 * Time: 下午10:02
 * Description:
 */
public class SmartParkingBoyTest {

    @Test
    public void should_park_the_car_to_the_second_parkingLot_when_the_first_parkingLot_has_less_rooms() throws ParkingLotFilledException {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot p1 = new ParkingLot(3);
        ParkingLot p2 = new ParkingLot(2);
        parkingLotList.add(p1);
        parkingLotList.add(p2);
        SmartParkingBoy smarkParkingBoy = new SmartParkingBoy(parkingLotList);

        //when
        smarkParkingBoy.park(new Car("A"));
        //then
        assertEquals(2, p1.getAvailableRoom());
        assertEquals(2, p2.getAvailableRoom());
        //when
        smarkParkingBoy.park(new Car("B"));
        //then
        assertEquals(1, p1.getAvailableRoom());
        assertEquals(2, p2.getAvailableRoom());

        //when
        smarkParkingBoy.park(new Car("C"));
        //then
        assertEquals(1, p1.getAvailableRoom());
        assertEquals(1, p2.getAvailableRoom());

    }
}
