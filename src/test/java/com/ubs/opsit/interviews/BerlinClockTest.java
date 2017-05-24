package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ubs.opsit.interviews.BerlinClock;

public class BerlinClockTest {

	private BerlinClock clock = new BerlinClock();

	@Test
	public void testBerlinClockAcceptsAndStoresHour() {
		Integer hour = 12;
		clock.setHour(hour);
		assertEquals("Hour value is altered", clock.getHour(), hour);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBerlinClockChecksBoundryLimitsForHour() {
		clock.setHour(-12);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBerlinClockChecksCeilLimitsForHour() {
		clock.setHour(25);
	}

	@Test
	public void testBerlinClockAcceptsAndStoresMinutes() {
		Integer minute = 26;
		clock.setMinute(minute);
		assertEquals("Minute value is altered", clock.getMinute(), minute);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBerlinClockChecksBoundryLimitsForMinute() {
		clock.setMinute(-12);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBerlinClockChecksCeilLimitsForMinute() {
		clock.setMinute(75);
	}

	@Test
	public void testBerlinClockAcceptsAndStoresSecond() {
		Integer second = 12;
		clock.setSecond(second);
		assertEquals("Second value is altered.", clock.getSecond(), second);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBerlinClockChecksBoundryLimitsForSecond() {
		clock.setSecond(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBerlinClockChecksCeilLimitsForSecond() {
		clock.setSecond(61);
	}

	@Test
	public void testBerlinClockDisplayHas24Lights() {
		clock.setHour(13);
		clock.setMinute(59);
		clock.setSecond(34);
		assertEquals("Clock display was not confined to 24 lights.", clock.display().replaceAll("\n", "").length(), 24);
	}

	@Test
	public void testBerlinClockDisplayProperLightsSampleCase() {
		clock.setHour(23);
		clock.setMinute(59);
		clock.setSecond(59);
		String expected = "O\n" //
				+ "RRRR\n" //
				+ "RRRO\n" //
				+ "YYRYYRYYRYY\n" //
				+ "YYYY"; //
		assertEquals(clock.display(), expected);
	}

	@Test
	public void testBerlinClockDisplayProperLightsSampleCaseAsConverter() {
		String expected = "O\n" //
				+ "RRRR\n" //
				+ "RRRO\n" //
				+ "YYRYYRYYRYY\n" //
				+ "YYYY"; //
		assertEquals(clock.convertTime("23:59:59"), expected);
	}
}