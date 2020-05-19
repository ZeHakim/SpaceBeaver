package app.components.events;

import java.io.Serializable;
import java.time.LocalTime;

public class TimeStamp implements Comparable<Object>, Serializable{

	private static final long serialVersionUID = 1L;
	private LocalTime locaTime;
	
	public TimeStamp () {
		locaTime = LocalTime.now();
	}

	@Override
	public int compareTo(Object arg0) {
		TimeStamp cast = (TimeStamp) arg0;
		if (cast.equals(locaTime)) return 0;
		return this.compareTo(arg0);
	}
	
	public int compareTo(TimeStamp arg0) {
		return this.compareTo(arg0);
	}
	
	/**
	 * Methode qui renvoie le temps local
	 * @return localTime
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	public LocalTime getTime() {
		return locaTime;
	}
	
	/**
	 * Methode qui renvoie le temps local sous forme de chaîne de caractéres 
	 * @return localTime
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	public String getTimestamper() {
		return locaTime.toString();
	}



}
