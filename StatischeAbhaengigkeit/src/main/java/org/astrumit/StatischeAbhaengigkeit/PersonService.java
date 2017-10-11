package org.astrumit.StatischeAbhaengigkeit;

import java.util.List;
import java.util.function.Consumer;

public class PersonService {
	private List<Person> existingPersons;
	private Consumer<Person> notifyPerson;

	public PersonService() {
		this(p -> MailGateway.notify(p));
	}
	
	public PersonService(Consumer<Person> notifyPerson) {
		this.notifyPerson = notifyPerson;
	}
	
	public void notifyIfExists(Person toBeNotified) {
		if (exists(toBeNotified)) {
			notifyPerson.accept(toBeNotified);
		}
	}
	
	public void setExistingPersons(List<Person> existingPersons) {
		this.existingPersons = existingPersons;
	}

	private boolean exists(Person toBeNotified) {
		return existingPersons.contains(toBeNotified);
	}
}
