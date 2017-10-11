package org.astrumit.StatischeAbhaengigkeit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersonService {
	private List<Person> existingPersons;

	public void notifyIfExists(Person toBeNotified) {
		if (exists(toBeNotified)) {
			MailGateway.notify(toBeNotified);
		}
	}
	
	public void setExistingPersons(List<Person> existingPersons) {
		this.existingPersons = existingPersons;
	}

	private boolean exists(Person toBeNotified) {
		return existingPersons.contains(toBeNotified);
	}
}
