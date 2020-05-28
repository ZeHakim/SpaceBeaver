package cep.domain.correlators;

import cep.domain.events.EventBase;

import java.util.ArrayList;

public class RuleBase {

    private ArrayList<RuleI> base = new ArrayList<RuleI>();

    public void addRule(RuleI rule) {
        base.add(rule);
    }

    public boolean fireFirstOn(EventBase events) {
        for (RuleI oneRule : base) {
            if (oneRule.executeOn(events)) { // TODO erreur à corriger
                return true;
            }
        }
        return false;
    }

    public boolean fireAllOn(EventBase events) {
        boolean res = false;
        while (fireFirstOn(events)) {
            res = true;
        }
        return res;
    }
}
