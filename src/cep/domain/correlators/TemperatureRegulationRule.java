package cep.domain.correlators;

import cep.domain.actuators.RegulateTemperature;
import cep.domain.events.EventBase;
import cep.domain.events.EventI;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class TemperatureRegulationRule extends AbstractRule  {


    public TemperatureRegulationRule(EventBase eventBase) {
        super();
        this.setEventBase(eventBase);
    }

    public static final EventMatcherI MATCHER_BAD_TEMPERATURE =
            (e -> (Double) e.getPropertyValue("target") != (Double) e.getPropertyValue("ambient"));

    @Override
    public RuleI clone() {
        return null;
    }


    @Override
    public ArrayList<EventI> trigger() {
        return (ArrayList<EventI>) this.getEventBase().getEvents().stream().filter(MATCHER_BAD_TEMPERATURE::match)
                .collect(Collectors.toList());
    }

    @Override
    public void actions(ArrayList<EventI> triggeringEvents) {
        RegulateTemperature regulateTemperature = new RegulateTemperature(((Double) triggeringEvents.get(0)
                .getPropertyValue("ambient")),
                ((Double) triggeringEvents.get(0).getPropertyValue("target")));
        // Change target Temperature
        regulateTemperature.execute();
    }
}
