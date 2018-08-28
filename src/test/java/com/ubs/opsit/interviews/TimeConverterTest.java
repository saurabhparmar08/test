package com.ubs.opsit.interviews;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TimeConverterTest {
    private TimeConverter berlinClock;
    private String theTime;
    
    @Before
    public void setUp(){
    	berlinClock = new TimeConverterImpl();
    }
    
	@Test(expected = IllegalArgumentException.class)
	public void nullInputTimeStringTest(){
		theTime = null;
		berlinClock.convertTime(theTime);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void emptyInputTimeStringTest(){
		theTime = "";
		berlinClock.convertTime(theTime);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void emptyInvalidTimeStringTest(){
		theTime = "60";
		berlinClock.convertTime(theTime);
	}
    
	@Test(expected = IllegalArgumentException.class)
	public void invalidInputHoursTest(){
		theTime = "25:14:34";
		berlinClock.convertTime(theTime);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidInputMinutesTest(){
		theTime = "22:60:34";
		berlinClock.convertTime(theTime);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidInputSecondsTest(){
		theTime = "22:20:71";
		berlinClock.convertTime(theTime);
	}
	
	@Test
	public void convertIntermediateTimeTest(){
		theTime = "15:29:44";
		String output = berlinClock.convertTime(theTime);
		String expected = "Y\n" +
						  "RRRO\n"+
						  "OOOO\n"+
						  "YYRYYOOOOOO\n"+
						  "YYYY";
		assertEquals(expected, output);
	}
	
	@Test
	public void convertMidnightTest(){
		berlinClock = new TimeConverterImpl();
		theTime = "00:00:00";
		String output = berlinClock.convertTime(theTime);
		String expected = "Y\n"
				+ "OOOO\n"
				+ "OOOO\n"
				+ "OOOOOOOOOOO\n"
				+ "OOOO";
		assertEquals(expected, output);
	}
	
	@Test
	public void convertMiddleAfternoonTest(){
		berlinClock = new TimeConverterImpl();
		theTime = "13:17:01";
		String output = berlinClock.convertTime(theTime);
		String expected = "O\n"
				+ "RROO\n"
				+ "RRRO\n"
				+ "YYROOOOOOOO\n"
				+ "YYOO";
		assertEquals(expected, output);
	}
	
	@Test
	public void convertJustBeforeMidnightTest(){
		berlinClock = new TimeConverterImpl();
		theTime = "23:59:59";
		String output = berlinClock.convertTime(theTime);
		String expected = "O\n"
				+ "RRRR\n"
				+ "RRRO\n"
				+ "YYRYYRYYRYY\n"
				+ "YYYY";
		assertEquals(expected, output);
	}
	
	@Test
	public void convertMidnightEndTest(){
		berlinClock = new TimeConverterImpl();
		theTime = "24:00:00";
		String output = berlinClock.convertTime(theTime);
		String expected = "Y\n"
				+ "RRRR\n"
				+ "RRRR\n"
				+ "OOOOOOOOOOO\n"
				+ "OOOO";
		assertEquals(expected, output);
	}
	
	@After
	public void tearDown(){
		berlinClock = null;
	}

}
