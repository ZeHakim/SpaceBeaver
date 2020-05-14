package app.components.event;

import java.io.Serializable;
import java.time.LocalTime;

public class TimeStamp implements Comparable, Serializable{
	private LocalTime locaTime;
	
	public TimeStamp () {
		locaTime = LocalTime.now();
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
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
