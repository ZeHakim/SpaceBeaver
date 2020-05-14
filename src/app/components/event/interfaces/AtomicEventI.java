package app.components.event.interfaces;

import java.io.Serializable;

public interface AtomicEventI extends EventI{
	
	public Serializable putProperty(String name, Serializable value);
	
	public Serializable removeProperty(String name);

}
