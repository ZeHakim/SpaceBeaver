package cep.domain.correlators;

import java.util.ArrayList;

import cep.domain.events.EventBase;

/**
 * 
 * classe comportant une liste de r�gles et deux m�thode qu'on peut ex�cuter soit pour trouver une regle qui fonctionne 
 * soit pour trouver toutes les regles qui fonctionnent 
 *
 */
public class RuleBase {
	private ArrayList<RuleI> base = new ArrayList<RuleI>();
	
	/**
	 * Add a new RuleI to the RuleBase
	 * @param rule : RuleI to add to the RuleBase
	 */
	public void addRule(RuleI rule) {
		base.add(rule);
	}
	
	/**
	 * try to execute rules on the events's base and return true when one is executed
	 * @param events: EventBase to try the RuleI s  on
	 * @return true if a rule has been executed and false otherwise
	 */
	public boolean fireFirstOn (EventBase events) {
		for (RuleI oneRule : base) {
			if (oneRule.executeOn(events)){ // TODO erreur à corriger
				return true;
			}
		}
		return false;
	}
	
	/**
	 * call fireFirstOn while it returns true, that is to say while a rule is executed on the EventBase
	 * @param events: EventBase to try the RuleI s  on
	 * @return true if at least one rule has been executed on the EventBase
	 */
	public boolean fireAllOn (EventBase events) {
		boolean res=false;
		while (fireFirstOn(events)) {
			res=true;
		}
		return res;
	}
}
