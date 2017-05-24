package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.Light.Red;
import static com.ubs.opsit.interviews.Light.Yellow;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LightTest {

	@Test
	public void testRedLightOnValue() {
		assertEquals(Red.asDisplay(true), "R");
	}

	@Test
	public void testYellowLightOnValue() {
		assertEquals(Yellow.asDisplay(true), "Y");
	}

	@Test
	public void testLightOffValue() {
		assertEquals(Yellow.asDisplay(false), "O");
		assertEquals(Red.asDisplay(false), "O");
	}
}
