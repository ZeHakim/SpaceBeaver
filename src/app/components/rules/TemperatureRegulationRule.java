package app.components.rules;

import java.util.ArrayList;
import java.util.stream.Collectors;

import app.commands.TemperatureCommand;
import app.components.events.EventBase;
import app.interfaces.commands.ExecutorCommandI;
import app.interfaces.events.EventI;
import app.interfaces.rules.EventMatcherI;
import app.interfaces.rules.RuleI;

public class TemperatureRegulationRule implements RuleI, ExecutorCommandI {

    private EventBase eventBase;

    public TemperatureRegulationRule(EventBase eventBase) {
        this.eventBase = eventBase;
    }

    public static final EventMatcherI MATCHER_BAD_TEMPERATURE =
            (e -> (Double) e.getPropertyValue("target") != (Double) e.getPropertyValue("ambient"));

    @Override
    public RuleI clone() {
        return null;
    }


    @Override
    public EventI match(EventMatcherI matcher) {
        return this.eventBase.getEvents().stream().filter(matcher::match).findFirst().orElse(null);
    }

    @Override
    public ArrayList<EventI> trigger() {
        return (ArrayList<EventI>) this.eventBase.getEvents().stream().filter(MATCHER_BAD_TEMPERATURE::match).collect(Collectors.toList());
    }

    @Override
    public void actions(ArrayList<EventI> triggeringEvents) {
        TemperatureCommand temperatureCommand = new TemperatureCommand(((Double) triggeringEvents.get(0).getPropertyValue("ambient")),
                ((Double) triggeringEvents.get(0).getPropertyValue("target")));
        // emit the alarm
        temperatureCommand.execute();
    }

    @Override
    public void effects(ArrayList<EventI> triggeringEvents) {
        triggeringEvents.forEach(eventI -> this.eventBase.removeEvent(eventI));
    }

    @Override
    public void executeOn() {
        ArrayList<EventI> eventIS = this.trigger();
        if (eventIS != null) {
            this.actions(eventIS);
            this.effects(eventIS);
        }
    }

    @Override
    public void execute() {
        this.executeOn();
    }
}
