package com.jp.parkinglot.tddparkinglot;

import com.jp.parkinglot.tddparkinglot.bean.Car;
import com.jp.parkinglot.tddparkinglot.exception.ParkingLotFilledException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * User: androidjp
 * Date: 2018/5/31
 * Time: 下午11:03
 * Description:
 */
public class SuperParkingBoyTest {

    @Test
    public void should_park_the_car_into_second_parkingLot_when_the_rate_of_empty_room_is_bigger_than_first_one() throws ParkingLotFilledException {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot p1 = new ParkingLot(3);
        ParkingLot p2 = new ParkingLot(2);
        parkingLotList.add(p1);
        parkingLotList.add(p2);

        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLotList);

        superParkingBoy.park(new Car("A"));
        assertEquals(2, p1.getAvailableRoom());
        assertEquals(2, p2.getAvailableRoom());
        superParkingBoy.park(new Car("B"));
        assertEquals(2, p1.getAvailableRoom());
        assertEquals(1, p2.getAvailableRoom());
    }

}
