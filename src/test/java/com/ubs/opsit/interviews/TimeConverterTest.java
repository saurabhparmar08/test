package com.ubs.opsit.interviews;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeConverterTest {
    private TimeConverter berlinClock;
    private String theTime;
    
	@Test(expected = IllegalArgumentException.class)
	public void nullInputTimeStringTest(){
		berlinClock = new TimeConverterImpl();
		theTime = null;
		berlinClock.convertTime(theTime);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void emptyInputTimeStringTest(){
		berlinClock = new TimeConverterImpl();
		theTime = "";
		berlinClock.convertTime(theTime);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void emptyInvalidTimeStringTest(){
		berlinClock = new TimeConverterImpl();
		theTime = "60";
		berlinClock.convertTime(theTime);
	}
    
	@Test(expected = IllegalArgumentException.class)
	public void invalidInputHoursTest(){
		berlinClock = new TimeConverterImpl();
		theTime = "25:14:34";
		berlinClock.convertTime(theTime);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidInputMinutesTest(){
		berlinClock = new TimeConverterImpl();
		theTime = "22:60:34";
		berlinClock.convertTime(theTime);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidInputSecondsTest(){
		berlinClock = new TimeConverterImpl();
		theTime = "22:20:71";
		berlinClock.convertTime(theTime);
	}
	
	@Test
	public void printConvertedTimeTest(){
		berlinClock = new TimeConverterImpl();
		theTime = "15:29:44";
		String output = berlinClock.convertTime(theTime);
		String expected = "Y\n" +
						  "RRR0\n"+
						  "0000\n"+
						  "YYRYY000000\n"+
						  "YYYY";
		assertEquals(expected, output);
	}

}
