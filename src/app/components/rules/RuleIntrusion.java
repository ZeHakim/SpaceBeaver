package app.components.rules;

import java.util.ArrayList;

import app.components.events.EventBase;
import app.interfaces.events.EventI;
import app.interfaces.rules.EventMatcherI;
import app.interfaces.rules.RuleI;

public class RuleIntrusion implements RuleI{
	
	
	public static final EventMatcherI MATCHER_WINDOW_OPEN =
			(e -> e.getProperty("type").
			equals("window open")) ;
	
	public static final EventMatcherI MATCHER_PRESENCE_DETECTION =
			(e -> e.getProperty("type").
			equals("presence detection")) ;

	@Override
	public EventI match(EventMatcherI matcher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<EventI> trigger() {
		EventI windowOpen = this.match(MATCHER_WINDOW_OPEN) ;
		EventI presence = this.match(MATCHER_PRESENCE_DETECTION) ;
		if (windowOpen.getTimeStamp().compareTo(presence.getTimeStamp()) <= 0) {
		// the event window open happened before the detection of a
		// presence, hence we suspect an intrusion.
		ArrayList<EventI> ret = new ArrayList<EventI>() ;
		ret.add(windowOpen) ;
		ret.add(presence) ;
		return ret ;
		} else {
		// no intrusion detected.
		return null ;
		}
	}

	@Override
	public void actions(ArrayList<EventI> triggeringEvents) {
//		BuildingAlarm alarm =
//				new BuildingAlarm(
//				((String)triggerringEvents.get(0).getPropertyValue("room")),
//				"intrusion detected at " +
//				triggerringEvents.get(0).getTimeStamp().getTime()) ;
//				// emit the alarm
//				System.out.println(alarm.toString()) ;
		System.out.println("activation alarm !");
		
	}

	@Override
	public void effects(ArrayList<EventI> triggeringEvents) {
//		this.eventBase.removeEvent(triggerringEvents.get(0)) ;
//		this.eventBase.removeEvent(triggerringEvents.get(1)) ;
		System.out.println("suppression des event qui on déclanche alarm");
		
	}

	@Override
	public boolean executeOn(EventBase events) {
		// TODO Auto-generated method stub
		return false;
	}

}
