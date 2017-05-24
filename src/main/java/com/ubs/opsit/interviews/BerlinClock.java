package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.Light.Red;
import static com.ubs.opsit.interviews.Light.Yellow;

public class BerlinClock implements TimeConverter {

	private Integer hour;
	private Integer minute;
	private Integer second = 0;

	public void setHour(Integer hour) {
		checkNegative(hour);
		checkCeilingFor("Hour", hour, 24);

		this.hour = hour;
	}

	private void checkCeilingFor(String type, Integer value, Integer ceil) {
		if (value > ceil) {
			throw new IllegalArgumentException(type + " value cannot be greater than " + ceil);
		}
	}

	private void checkNegative(Integer value) {
		if (value < 0) {
			throw new IllegalArgumentException("Clock timings does not have negative value.");
		}
	}

	public Integer getHour() {
		return hour;
	}

	public void setMinute(Integer minute) {
		checkNegative(minute);
		checkCeilingFor("Minute", minute, 60);

		this.minute = minute;
	}

	public Integer getMinute() {
		return minute;
	}

	public void setSecond(Integer second) {
		checkNegative(second);
		checkCeilingFor("Second", second, 60);

		this.second = second;
	}

	public Integer getSecond() {
		return second;
	}

	private final Light ClockConfinguration[] = { //
			Yellow, // seconds blinker
			Red, Red, Red, Red, // hour
			Red, Red, Red, Red, // hour
			Yellow, Yellow, Red, Yellow, Yellow, Red, Yellow, Yellow, Red, Yellow, Yellow, // minute
			Yellow, Yellow, Yellow, Yellow // minute
	};

	private final Integer secondsIndex = 0;
	private final Integer hourFirstLineIndex[] = { 1, 2, 3, 4 };
	private final Integer hourSecondLineIndex[] = { 5, 6, 7, 8 };
	private final Integer minuteFirstLineIndex[] = { 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
	private final Integer minuteSecondLineIndex[] = { 20, 21, 22, 23 };

	private final Integer newLineBreaks[] = { 1, 6, 11, 23 };

	private final Boolean currentTime[] = new Boolean[24];

	public String display() {
		currentTime[secondsIndex] = (this.second % 2 == 0);

		int hourFirstLineState = this.hour / 5;
		assignValuesToMatrix(hourFirstLineState, hourFirstLineIndex);

		int hourSecondLineState = this.hour % 5;
		assignValuesToMatrix(hourSecondLineState, hourSecondLineIndex);

		int minuteFirstLineState = this.minute / 5;
		assignValuesToMatrix(minuteFirstLineState, minuteFirstLineIndex);

		int minuteSecondLineState = this.minute % 5;
		assignValuesToMatrix(minuteSecondLineState, minuteSecondLineIndex);

		StringBuilder builder = new StringBuilder();
		for (int ofIndex = 0; ofIndex < currentTime.length; ofIndex++) {
			builder.append(ClockConfinguration[ofIndex].asDisplay(currentTime[ofIndex]));
		}

		for (Integer breaks : newLineBreaks) {
			builder.insert(breaks, "\n");
		}

		return builder.toString();
	}

	private void assignValuesToMatrix(int lineLitUpTo, final Integer[] lineIndices) {
		for (int current = 0; current < lineIndices.length; current++) {
			int atThisStage = lineIndices[current];
			if (current < lineLitUpTo) {
				currentTime[atThisStage] = true;
			} else {
				currentTime[atThisStage] = false;
			}
		}
	}

	@Override
	public String convertTime(String time) {
		if (time == null) {
			return null;
		}

		String tokens[] = time.split(":");
		this.setHour(Integer.parseInt(tokens[0]));
		this.setMinute(Integer.parseInt(tokens[1]));
		this.setSecond(Integer.parseInt(tokens[2]));

		return display();
	}
}