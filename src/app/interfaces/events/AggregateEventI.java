package app.components.interfaces;

import java.util.ArrayList;

public interface AggregateEventI extends EventI{
	
	public ArrayList<EventI> getCorrelatedEvents();

}
