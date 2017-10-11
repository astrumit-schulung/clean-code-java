package org.astrumit.StatischeAbhaengigkeit;

public class MailGatewayFacade implements IMailGateway{

	public void notify(Person person) {
		MailGateway.notify(person);
	}
}
