package com.jp.parkinglot.tddparkinglot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TddParkinglotApplicationTests {

	@Test
	public void contextLoads() {
		int a = 1,b = 1;
		assertEquals(2, a+b);
	}

}
