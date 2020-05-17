package app.tests.events;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.components.events.AtomicEvent;
import app.components.events.EventBase;
import app.components.events.TimeStamp;
import app.interfaces.events.AtomicEventI;

class EventBaseTest {

	@Test
	void testClearEvents() {
		fail("Not yet implemented");
	}

	@Test
	void testNumberOfEvents() {
		TimeStamp ts1 = new TimeStamp();
		String uri1 = "Test URI1";
		
		TimeStamp ts2 = new TimeStamp();
		//String uri2 = "Test URI2";
		
		System.out.println(ts1.compareTo(ts2));
		AtomicEventI event1 = new AtomicEvent(uri1, ts2);
		AtomicEventI event2 = new AtomicEvent(uri1, ts2);
		event1.putProperty("test1", "test1");
		event1.putProperty("test2", "test2");
		
		//String uri = "Test URI";
		//TimeStamp ts = new TimeStamp();
		
		EventBase base = new EventBase();
		
		base.addEvent(event1);
		base.addEvent(event2);
		
		
		assertEquals(base.numberOfEvents(), 2);
	}

	@Test
	void testGetEvent() {
		//TimeStamp ts1 = new TimeStamp();
		String uri1 = "Test URI1";
		
		TimeStamp ts2 = new TimeStamp();
		//String uri2 = "Test URI2";
		
		AtomicEventI event1 = new AtomicEvent(uri1, ts2);
		AtomicEventI event2 = new AtomicEvent(uri1, ts2);
		event1.putProperty("test1", "test1");
		event1.putProperty("test2", "test2");
		
		//String uri = "Test URI";
		//TimeStamp ts = new TimeStamp();
		
		EventBase base = new EventBase();
		
		base.addEvent(event1);
		base.addEvent(event2);
		
		
		assertEquals(base.getEvent(0), event1);
	}

	@Test
	void testAddEvent() {
		//TimeStamp ts1 = new TimeStamp();
		String uri1 = "Test URI1";
		
		TimeStamp ts2 = new TimeStamp();
		//String uri2 = "Test URI2";
		
		AtomicEventI event1 = new AtomicEvent(uri1, ts2);
		AtomicEventI event2 = new AtomicEvent(uri1, ts2);
		event1.putProperty("test1", "test1");
		event1.putProperty("test2", "test2");
		
		//String uri = "Test URI";
		//TimeStamp ts = new TimeStamp();
		
		EventBase base = new EventBase();
		
		base.addEvent(event1);
		base.addEvent(event2);
		
		assertEquals(base.numberOfEvents(), 2);
		assertEquals(base.getEvent(0), event1);
		assertEquals(base.getEvent(1), event2);
	}

	@Test
	void testRemoveEvent() {
		//TimeStamp ts1 = new TimeStamp();
		String uri1 = "Test URI1";
		
		TimeStamp ts2 = new TimeStamp();
		//String uri2 = "Test URI2";
		
		AtomicEventI event1 = new AtomicEvent(uri1, ts2);
		AtomicEventI event2 = new AtomicEvent(uri1, ts2);
		event1.putProperty("test1", "test1");
		event1.putProperty("test2", "test2");
		
		//String uri = "Test URI";
		//TimeStamp ts = new TimeStamp();
		
		EventBase base = new EventBase();
		
		base.addEvent(event1);
		base.addEvent(event2);
		
		assertTrue(base.appearsIn(event1));
		assertEquals(base.numberOfEvents(), 2);
		base.removeEvent(event1);
		assertFalse(base.appearsIn(event1));
		assertEquals(base.numberOfEvents(), 1);
	}

	@Test
	void testAppearsIn() {
		//TimeStamp ts1 = new TimeStamp();
		String uri1 = "Test URI1";
		
		TimeStamp ts2 = new TimeStamp();
		//String uri2 = "Test URI2";
		
		AtomicEventI event1 = new AtomicEvent(uri1, ts2);
		AtomicEventI event2 = new AtomicEvent(uri1, ts2);
		event1.putProperty("test1", "test1");
		event1.putProperty("test2", "test2");
		
		//String uri = "Test URI";
		//TimeStamp ts = new TimeStamp();
		
		EventBase base = new EventBase();
		
		assertEquals(base.numberOfEvents(), 0);
		assertFalse(base.appearsIn(event1));
		base.addEvent(event1);
		assertTrue(base.appearsIn(event1));
		assertFalse(base.appearsIn(event2));
		
	}

}
