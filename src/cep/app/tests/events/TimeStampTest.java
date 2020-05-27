package cep.app.tests.events;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cep.domain.events.TimeStamp;

class TimeStampTest {

	@Test
	void testCompareTo() {
		
		TimeStamp ts1 = new TimeStamp();
		TimeStamp ts2 = new TimeStamp();
		TimeStamp ts3 = new TimeStamp();
		
		System.out.println(ts1.compareTo(ts2));	
		assertTrue(ts1.compareTo(ts2) > 0);
		assertTrue(ts1.compareTo(ts1) == 0);
		assertTrue(ts3.compareTo(ts1) < 0);
	}

	@Test
	void testGetTime() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTimestamper() {
		fail("Not yet implemented");
	}

}
