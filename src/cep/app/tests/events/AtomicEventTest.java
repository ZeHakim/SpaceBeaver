package cep.app.tests.events;

import static org.junit.jupiter.api.Assertions.*;

import java.io.Serializable;

import org.junit.jupiter.api.Test;

import cep.domain.events.AtomicEvent;
import cep.domain.events.TimeStamp;
import cep.domain.events.AtomicEventI;

class AtomicEventTest {
	
	@Test
	void testGetURI() {	
		TimeStamp ts = new TimeStamp();
		String uri = "Test URI";
		
		AtomicEventI event = new AtomicEvent(uri);
		
		assertEquals(event.getURI(), uri);
	}

	@Test
	void testGetTimeStamp() {
		TimeStamp ts = new TimeStamp();
		String uri = "Test URI";
		
		AtomicEventI event = new AtomicEvent(uri);
		
		assertEquals(event.getTimeStamp().getClass(),TimeStamp.class);
		
	}

	@Test
	void testHasProperty() {
		TimeStamp ts = new TimeStamp();
		String uri = "Test URI";
		
		AtomicEventI event = new AtomicEvent(uri);
		
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
		
		AtomicEventI event = new AtomicEvent(uri);
		
		String name = "test1";
		Serializable value = "value";
		event.putProperty(name, value);
		
		assertEquals(event.getPropertyValue(name), value);
		assertNotEquals(event.getPropertyValue(name),"false");
	}

	@Test
	void testPutProperty() {
		TimeStamp ts = new TimeStamp();
		String uri = "Test URI";
		
		AtomicEventI event = new AtomicEvent(uri);
		
		String name = "test1";
		Serializable value = "value";
		event.putProperty(name, value);
		
		assertEquals(event.getPropertyValue(name), value);
	}

	@Test
	void testRemoveProperty() {
		TimeStamp ts = new TimeStamp();
		String uri = "Test URI";
		
		AtomicEventI event = new AtomicEvent(uri);
		
		String name = "test1";
		Serializable value = "value";
		event.putProperty(name, value);
		
		assertEquals(event.removeProperty(name), value);
	}

}
