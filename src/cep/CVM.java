package cep;

import cep.app.components.OldCEPBus;
import cep.app.components.PresenceDetector;
import cep.plug.connectors.ExecutorConnector;
import cep.plug.connectors.RegistrationConnector;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.cvm.AbstractCVM;
import cep.plug.components.Thermostat;
import cep.plug.components.ThermostatCorrelator;
import cep.plug.connectors.EventConnector;


public class CVM extends AbstractCVM {

	public static final String BUS_REGISTRATION_IN = "busRegistration";
	public static final String BUS_EVENT_RECEPTION_IN = "busEventReception";
	public static final String BUS_SEND_OUT = "BusSendEvent";

	public static final String THERMOSTAT_CORRELATOR_REGISTRATION_OUT = "correlatorRegistration";
	public static final String THERMOSTAT_CORRELATOR_EVENT_RECEPTION_IN = "correlatorEventReception";
	public static final String THERMOSTAT_CORRELATOR_COMMAND_OUT = "CorrelatorSendEvent";


	public static final String THERMOSTAT_REGISTRATION_OUT = "ThermostatSendEventRegistration";
	public static final String THERMOSTAT_SENDER_OUT = "ThermostatSendEvent";
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

		//Thermostat creation
		String uri1 = AbstractComponent.createComponent(
				Thermostat.class.getCanonicalName(),
				new Object[]{THERMOSTAT_SENDER_OUT, THERMOSTAT_REGISTRATION_OUT, THERMOSTAT_COMMAND_IN});

		//ThermostatCorrelator creation
		String uri2 = AbstractComponent.createComponent(
				ThermostatCorrelator.class.getCanonicalName(),
				new Object[]{THERMOSTAT_CORRELATOR_EVENT_RECEPTION_IN, THERMOSTAT_CORRELATOR_COMMAND_OUT, THERMOSTAT_CORRELATOR_REGISTRATION_OUT});

		//ThermostatSendEvent registration
		this.doPortConnection(uri1, THERMOSTAT_REGISTRATION_OUT, BUS_REGISTRATION_IN,
				RegistrationConnector.class.getCanonicalName());
		//ThermostatCorrelator registration
		this.doPortConnection(uri2, THERMOSTAT_CORRELATOR_REGISTRATION_OUT, BUS_REGISTRATION_IN,
				RegistrationConnector.class.getCanonicalName());

		//ThermostatSendEvent
		this.doPortConnection(uri1, THERMOSTAT_SENDER_OUT, BUS_EVENT_RECEPTION_IN,
				EventConnector.class.getCanonicalName());

		//BusSendEvent
		this.doPortConnection(busUri, BUS_SEND_OUT, THERMOSTAT_CORRELATOR_EVENT_RECEPTION_IN,
				EventConnector.class.getCanonicalName());

		//ThermostatCommand
		this.doPortConnection(uri2, THERMOSTAT_CORRELATOR_COMMAND_OUT, THERMOSTAT_COMMAND_IN,
				ExecutorConnector.class.getCanonicalName());

		//////////////////////////////
		//Composants
		/////////////

		super.deploy();
	}

	public static void main(String[] args) {
		try {
			CVM cvm = new CVM();
			cvm.startStandardLifeCycle(1000L);
			Thread.sleep(2000L);
			System.exit(0);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
