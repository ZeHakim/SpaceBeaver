package app.interfaces.rules;

import java.util.ArrayList;
import app.interfaces.events.EventI;
import app.components.events.EventBase;

import app.components.events.EventBase;
import app.interfaces.events.EventI;

/**
 *Interface des r�gles de de corr�lation des �venements. executeOn permet d'executer 
 *Les m�thodes dans l'odre pour tester une base d'�v�nement avec une r�gle
 * @author Gabriel Bouchez
 *
 */
public interface RuleI {
	//public RuleI clone();
	
	//public RuleI copyFrom(RuleI r);
	/**
	 * test all Event from EventBase and keep the last event that pass the test
	 * @param matcher: the lambda-expression of a predicate to test the events
	 * @return the last emited matching event
	 */
	public EventI match (EventMatcherI matcher);
	
	/**
	 * init the rule before executing it
	 */
	public void init();
	
	/**
	 * select events by calling match with various EventMatchers and return them if they exists
	 * @return the ArrayList of the events selected or null if they are none
	 */
	public ArrayList<EventI>   trigger();
	
	/**
	 * execute actions on triggeringEvents 
	 * @param triggeringEvents : the list of selected event comming from trigger()
	 */
	public void actions(ArrayList<EventI> triggeringEvents);
	
	/**
	 * performs side effects on internal rule data or on the basis of events.
	 * @param triggeringEvents : the list of selected event comming from trigger()
	 */
	public void effects(ArrayList<EventI> triggeringEvents);
	
	/**
	 * execute init(), trigger(), action() and effects if possible
	 * @param events : EventBase 
	 * @return true if was able to execute all Rule functions, false otherwise
	 */
	public boolean executeOn(EventBase events);
}
