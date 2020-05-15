package app.tests.events;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import app.components.events.AggregateEvent;
import app.components.events.AtomicEvent;
import app.components.events.TimeStamp;
import app.interfaces.events.AggregateEventI;
import app.interfaces.events.AtomicEventI;
import app.interfaces.events.EventI;

class AggregateEventTest {

	@Test
	void testGetURI() {
		TimeStamp ts1 = new TimeStamp();
		String uri1 = "Test URI1";
		
		TimeStamp ts2 = new TimeStamp();
		String uri2 = "Test URI2";
		
		AtomicEventI event1 = new AtomicEvent(uri1, ts2);
		AtomicEventI event2 = new AtomicEvent(uri1, ts2);
		
		String uri = "Test URI";
		TimeStamp ts = new TimeStamp();
		ArrayList<EventI> liste = new ArrayList<> ();
		liste.add(event1);
		liste.add(event2);
		
		AggregateEventI a = new AggregateEvent(uri, liste, ts);
		
		assertEquals(a.getURI(), uri);
	}

	@Test
	void testGetTimeStamp() {
		TimeStamp ts1 = new TimeStamp();
		String uri1 = "Test URI1";
		
		TimeStamp ts2 = new TimeStamp();
		String uri2 = "Test URI2";
		
		AtomicEventI event1 = new AtomicEvent(uri1, ts2);
		AtomicEventI event2 = new AtomicEvent(uri1, ts2);
		
		String uri = "Test URI";
		TimeStamp ts = new TimeStamp();
		ArrayList<EventI> liste = new ArrayList<> ();
		liste.add(event1);
		liste.add(event2);
		
		AggregateEventI a = new AggregateEvent(uri, liste, ts);
		
		assertEquals(a.getTimeStamp(), ts);
	}

	@Test
	void testHasProperty() {
		TimeStamp ts1 = new TimeStamp();
		String uri1 = "Test URI1";
		
		TimeStamp ts2 = new TimeStamp();
		String uri2 = "Test URI2";
		
		AtomicEventI event1 = new AtomicEvent(uri1, ts2);
		AtomicEventI event2 = new AtomicEvent(uri1, ts2);
		event1.putProperty("test1", "test1");
		event1.putProperty("test2", "test2");
		
		String uri = "Test URI";
		TimeStamp ts = new TimeStamp();
		ArrayList<EventI> liste = new ArrayList<> ();
		liste.add(event1);
		liste.add(event2);
		
		AggregateEventI a = new AggregateEvent(uri, liste, ts);
		
		assertTrue(a.hasProperty("test1"));
		assertTrue(a.hasProperty("test2"));
		assertFalse(a.hasProperty("test"));
	}

	@Test
	void testGetProperty() {
		TimeStamp ts1 = new TimeStamp();
		String uri1 = "Test URI1";
		
		TimeStamp ts2 = new TimeStamp();
		String uri2 = "Test URI2";
		
		AtomicEventI event1 = new AtomicEvent(uri1, ts2);
		AtomicEventI event2 = new AtomicEvent(uri1, ts2);
		event1.putProperty("test1", "test1");
		event1.putProperty("test2", "test2");
		
		String uri = "Test URI";
		TimeStamp ts = new TimeStamp();
		ArrayList<EventI> liste = new ArrayList<> ();
		liste.add(event1);
		liste.add(event2);
		
		AggregateEventI a = new AggregateEvent(uri, liste, ts);
		
		assertEquals(a.getProperty("test1"), "test1");
		assertEquals(a.getProperty("test2"), "test2");
		assertNotEquals(a.getProperty("test"), "test");
	}

	@Test
	void testGetCorrelatedEvents() {
		TimeStamp ts1 = new TimeStamp();
		String uri1 = "Test URI1";
		
		TimeStamp ts2 = new TimeStamp();
		String uri2 = "Test URI2";
		
		AtomicEventI event1 = new AtomicEvent(uri1, ts2);
		AtomicEventI event2 = new AtomicEvent(uri1, ts2);
		event1.putProperty("test1", "test1");
		event1.putProperty("test2", "test2");
		
		String uri = "Test URI";
		TimeStamp ts = new TimeStamp();
		ArrayList<EventI> liste = new ArrayList<> ();
		liste.add(event1);
		liste.add(event2);
		
		AggregateEventI a = new AggregateEvent(uri, liste, ts);
		
		assertEquals(a.getCorrelatedEvents(), liste);
	}

}
