package app.interfaces.events;

import java.util.ArrayList;

public interface AggregateEventI extends EventI{
	
	public ArrayList<EventI> getCorrelatedEvents();

}
