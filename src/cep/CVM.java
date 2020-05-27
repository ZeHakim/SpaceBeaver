package cep;

import cep.app.components.OldCEPBus;
import cep.app.components.PresenceDetector;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.cvm.AbstractCVM;
import cep.plug.components.Thermostat;
import cep.plug.components.ThermostatCommand;
import cep.plug.components.ThermostatCorrelator;
import cep.plug.connector.EventConnector;


public class CVM extends AbstractCVM {

	public static final String BUS_REGISTRATION_IN = "busRegistration";
	public static final String BUS_EVENT_RECEPTION_IN = "busEventReception";
	public static final String BUS_SEND_OUT = "BusSendEvent";

	public static final String CORRELATOR_REGISTRATION_OUT = "correlatorRegistration";
	public static final String CORRELATOR_EVENT_RECEPTION_IN = "correlatorEventReception";
	public static final String CORRELATOR_COMMAND_OUT = "CorrelatorSendEvent";


	public static final String THERMOSTAT_SEND_REG_OUT = "ThermostatSendEventRegistration";
	public static final String THERMOSTAT_SEND_OUT = "ThermostatSendEvent";

	public static final String THERMOSTAT_COMMAND_REG_OUT = "ThermostatCommandRegistration";
	public static final String THERMOSTAT_COMMAND_OUT = "ThermostatCommandExecuteOut";
	public static final String THERMOSTAT_COMMAND_IN = "ThermostatCommandExecuteIn";

	public CVM() throws Exception {
	}

	/**
	 * @see fr.sorbonne_u.components.cvm.AbstractCVM#deploy()
	 */
	@Override
	public void deploy() throws Exception {
		AbstractComponent.createComponent(PresenceDetector.class.getCanonicalName(), new Object[] {});
		AbstractComponent.createComponent(OldCEPBus.class.getCanonicalName(), new Object[] {});

		//Bus creation
		String busUri = AbstractComponent.createComponent(
				cep.plug.components.CEPBus.class.getCanonicalName(),
				new Object[]{BUS_REGISTRATION_IN, BUS_EVENT_RECEPTION_IN, BUS_SEND_OUT});

		//ThermostatCommand creation
		String uri2 = AbstractComponent.createComponent(
				ThermostatCommand.class.getCanonicalName(),
				new Object[]{THERMOSTAT_COMMAND_IN, THERMOSTAT_COMMAND_REG_OUT});

		//ThermostatSendEvent creation
		String uri = AbstractComponent.createComponent(
				Thermostat.class.getCanonicalName(),
				new Object[]{THERMOSTAT_SEND_OUT, THERMOSTAT_SEND_REG_OUT});

		//ThermostatCorrelator creation
		String uri3 = AbstractComponent.createComponent(
				ThermostatCorrelator.class.getCanonicalName(),
				new Object[]{CORRELATOR_EVENT_RECEPTION_IN, CORRELATOR_COMMAND_OUT, CORRELATOR_REGISTRATION_OUT});

		//ThermostatCommand registration
		this.doPortConnection(uri2, THERMOSTAT_COMMAND_REG_OUT, BUS_REGISTRATION_IN,
				EventConnector.class.getCanonicalName());
		//ThermostatSendEvent registration
		this.doPortConnection(uri, THERMOSTAT_SEND_REG_OUT, BUS_REGISTRATION_IN,
				EventConnector.class.getCanonicalName());
		//ThermostatCorrelator registration
		this.doPortConnection(uri3, CORRELATOR_REGISTRATION_OUT, BUS_REGISTRATION_IN,
				EventConnector.class.getCanonicalName());

		//ThermostatSendEvent
		this.doPortConnection(uri, THERMOSTAT_SEND_OUT, BUS_EVENT_RECEPTION_IN,
				EventConnector.class.getCanonicalName());

		//BusSendEvent
		this.doPortConnection(busUri, BUS_SEND_OUT, CORRELATOR_EVENT_RECEPTION_IN,
				EventConnector.class.getCanonicalName());

		//////////////////////////////
		//Composants
		/////////////

		super.deploy();
	}

	public static void main(String[] args) {
		try {
			CVM cvm = new CVM();
			cvm.startStandardLifeCycle(1000L);
			Thread.sleep(10000L);
			System.exit(0);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
