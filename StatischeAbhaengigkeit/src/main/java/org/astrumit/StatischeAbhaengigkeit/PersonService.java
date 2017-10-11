package org.astrumit.StatischeAbhaengigkeit;

import java.util.List;

public class PersonService {
	private List<Person> existingPersons;
	private IMailGateway mailGateway;

	public PersonService() {
		this(new MailGatewayFacade());
	}
	
	public PersonService(IMailGateway mailGateway) {
		this.mailGateway = mailGateway;
	}
	
	public void notifyIfExists(Person toBeNotified) {
		if (exists(toBeNotified)) {
			mailGateway.notify(toBeNotified);
		}
	}
	
	public void setExistingPersons(List<Person> existingPersons) {
		this.existingPersons = existingPersons;
	}

	private boolean exists(Person toBeNotified) {
		return existingPersons.contains(toBeNotified);
	}
}
