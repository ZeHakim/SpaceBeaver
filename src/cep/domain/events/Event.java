package cep.domain.events;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Event implements EventI{
	
	private static final long serialVersionUID = 1L;
	private String uri;
	private TimeStamp timeStamp;
	private ArrayList<EventI> correlatedEvents;
	
	
	public Event(String uri) {
		this.uri = uri;
		this.timeStamp = new TimeStamp();
	}
	
	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return uri;
	}

	@Override
	public TimeStamp getTimeStamp() {
		// TODO Auto-generated method stub
		return timeStamp;
	}

	@Override
	public boolean hasProperty(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable getPropertyValue(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
