package app.components.events;

import java.io.Serializable;

import app.interfaces.events.EventI;

public class Event implements EventI{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeStamp getTimeStamp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasProperty(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable getProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
