package app.tests.events;

import static org.junit.jupiter.api.Assertions.*;

import java.io.Serializable;

import org.junit.jupiter.api.Test;

import app.components.events.AtomicEvent;
import app.components.events.TimeStamp;
import app.interfaces.events.AtomicEventI;
import app.interfaces.events.EventI;

class AtomicEventTest {
	
	@Test
	void testGetURI() {	
		TimeStamp ts = new TimeStamp();
		String uri = "Test URI";
		
		AtomicEventI event = new AtomicEvent(uri, ts);
		
		assertEquals(event.getURI(), uri);
	}

	@Test
	void testGetTimeStamp() {
		TimeStamp ts = new TimeStamp();
		String uri = "Test URI";
		
		AtomicEventI event = new AtomicEvent(uri, ts);
		
		assertEquals(event.getTimeStamp(), ts);
	}

	@Test
	void testHasProperty() {
		TimeStamp ts = new TimeStamp();
		String uri = "Test URI";
		
		AtomicEventI event = new AtomicEvent(uri, ts);
		
		String name = "test1";
		Serializable value = "value";
		event.putProperty(name, value);
		
		assertTrue(event.hasProperty(name));
		assertFalse(event.hasProperty("false"));
	}

	@Test
	void testGetProperty() {
		TimeStamp ts = new TimeStamp();
		String uri = "Test URI";
		
		AtomicEventI event = new AtomicEvent(uri, ts);
		
		String name = "test1";
		Serializable value = "value";
		event.putProperty(name, value);
		
		assertEquals(event.getProperty(name), value);
		assertNotEquals(event.getProperty(name),"false");
	}

	@Test
	void testPutProperty() {
		TimeStamp ts = new TimeStamp();
		String uri = "Test URI";
		
		AtomicEventI event = new AtomicEvent(uri, ts);
		
		String name = "test1";
		Serializable value = "value";
		event.putProperty(name, value);
		
		assertEquals(event.getProperty(name), value);
	}

	@Test
	void testRemoveProperty() {
		TimeStamp ts = new TimeStamp();
		String uri = "Test URI";
		
		AtomicEventI event = new AtomicEvent(uri, ts);
		
		String name = "test1";
		Serializable value = "value";
		event.putProperty(name, value);
		
		assertEquals(event.removeProperty(name), value);
	}

}
