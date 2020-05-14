package app.components.event.interfaces;
import java.io.Serializable;

import app.components.event.TimeStamp;

public interface EventI extends Serializable{
	
	public String getURI();
	
	public TimeStamp getTimeStamp();
	
	public boolean hasProperty();
	
	public Serializable getProperty();

}
