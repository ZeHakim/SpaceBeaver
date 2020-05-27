package cep.app.tests.events;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import cep.domain.events.AggregateEvent;
import cep.domain.events.AtomicEvent;
import cep.domain.events.TimeStamp;
import cep.domain.events.AggregateEventI;
import cep.domain.events.AtomicEventI;
import cep.domain.events.EventI;

class AggregateEventTest {

	@Test
	void testGetURI() {
		//TimeStamp ts1 = new TimeStamp();
		String uri1 = "Test URI1";
		
		TimeStamp ts2 = new TimeStamp();
		//String uri2 = "Test URI2";
		
		AtomicEventI event1 = new AtomicEvent(uri1);
		AtomicEventI event2 = new AtomicEvent(uri1);
		
		String uri = "Test URI";
		TimeStamp ts = new TimeStamp();
		ArrayList<EventI> liste = new ArrayList<> ();
		liste.add(event1);
		liste.add(event2);
		
		AggregateEventI a = new AggregateEvent(uri, liste);
		
		assertEquals(a.getURI(), uri);
	}

	@Test
	void testGetTimeStamp() {
		//TimeStamp ts1 = new TimeStamp();
		String uri1 = "Test URI1";
		
		TimeStamp ts2 = new TimeStamp();
		//String uri2 = "Test URI2";
		
		AtomicEventI event1 = new AtomicEvent(uri1);
		AtomicEventI event2 = new AtomicEvent(uri1);
		
		String uri = "Test URI";
		TimeStamp ts = new TimeStamp();
		ArrayList<EventI> liste = new ArrayList<> ();
		liste.add(event1);
		liste.add(event2);
		
		AggregateEventI a = new AggregateEvent(uri, liste);
		
		assertEquals(a.getTimeStamp().getClass(),TimeStamp.class);
	}

	@Test
	void testHasProperty() {
		//TimeStamp ts1 = new TimeStamp();
		String uri1 = "Test URI1";
		
		TimeStamp ts2 = new TimeStamp();
		//String uri2 = "Test URI2";
		
		AtomicEventI event1 = new AtomicEvent(uri1);
		AtomicEventI event2 = new AtomicEvent(uri1);
		event1.putProperty("test1", "test1");
		event1.putProperty("test2", "test2");
		
		String uri = "Test URI";
		TimeStamp ts = new TimeStamp();
		ArrayList<EventI> liste = new ArrayList<> ();
		liste.add(event1);
		liste.add(event2);
		
		AggregateEventI a = new AggregateEvent(uri, liste);
		
		assertTrue(a.hasProperty("test1"));
		assertTrue(a.hasProperty("test2"));
		assertFalse(a.hasProperty("test"));
	}

	@Test
	void testGetProperty() {
		//TimeStamp ts1 = new TimeStamp();
		String uri1 = "Test URI1";
		
		TimeStamp ts2 = new TimeStamp();
		//String uri2 = "Test URI2";
		
		AtomicEventI event1 = new AtomicEvent(uri1);
		AtomicEventI event2 = new AtomicEvent(uri1);
		event1.putProperty("test1", "test1");
		event1.putProperty("test2", "test2");
		
		String uri = "Test URI";
		TimeStamp ts = new TimeStamp();
		ArrayList<EventI> liste = new ArrayList<> ();
		liste.add(event1);
		liste.add(event2);
		
		AggregateEventI a = new AggregateEvent(uri, liste);
		
		assertEquals(a.getPropertyValue("test1"), "test1");
		assertEquals(a.getPropertyValue("test2"), "test2");
		assertNotEquals(a.getPropertyValue("test"), "test");
	}

	@Test
	void testGetCorrelatedEvents() {
		//TimeStamp ts1 = new TimeStamp();
		String uri1 = "Test URI1";
		
		TimeStamp ts2 = new TimeStamp();
		//String uri2 = "Test URI2";
		
		AtomicEventI event1 = new AtomicEvent(uri1);
		AtomicEventI event2 = new AtomicEvent(uri1);
		event1.putProperty("test1", "test1");
		event1.putProperty("test2", "test2");
		
		String uri = "Test URI";
		TimeStamp ts = new TimeStamp();
		ArrayList<EventI> liste = new ArrayList<> ();
		liste.add(event1);
		liste.add(event2);
		
		AggregateEventI a = new AggregateEvent(uri, liste);
		
		assertEquals(a.getCorrelatedEvents(), liste);
	}

}
