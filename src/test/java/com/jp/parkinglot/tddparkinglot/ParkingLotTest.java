package com.jp.parkinglot.tddparkinglot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: androidjp
 * Date: 2018/5/26
 * Time: 下午11:08
 * Description:
 */
public class ParkingLotTest {
    @Test
    public void should_return_2_when_ask_for_the_available_rooms_count_of_a_parkingLot_which_has_2_rooms_and_has_no_parking_car() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        // when
        int count = parkingLot.getAvailableCount();
        // then
        assertEquals(2, count);
    }

    @Test
    public void should_return_1_when_ask_for_the_available_rooms_count_of_a_parkingLot_which_has_2_rooms_and_after_parking_one_car() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        Car car = new Car("A123");
        parkingLot.park(car);
        // when
        int count = parkingLot.getAvailableCount();
        // then
        assertEquals(1, count);
    }

    @Test
    public void should_return_ticket$100$_when_park_first_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("A123");
        //when
        CarTicket ticket = parkingLot.park(car);
        //then
        assertEquals(100, ticket.getId());
    }

    @Test
    public void should_return_ticket$102$_when_park_third_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.park(new Car("A"));
        parkingLot.park(new Car("B"));
        //when
        CarTicket ticketC = parkingLot.park(new Car("C"));
        //then
        assertEquals(102, ticketC.getId());
    }

    @Test
    public void should_return_car_when_give_the_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        Car carA = new Car("A");
        Car carB = new Car("B");
        CarTicket ticketA = parkingLot.park(carA);
        CarTicket ticketB = parkingLot.park(carB);
        //when
        Car resCarA = parkingLot.pickUp(ticketA);
        Car resCarB = parkingLot.pickUp(ticketB);
        //then
        assertEquals(resCarA, carA);
        assertEquals(resCarB, carB);
    }
}
