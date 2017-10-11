package org.astrumit.StatischeAbhaengigkeit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersonService {
	public void notifyIfExists(Person toBeNotified) {
		if (exists(toBeNotified)) {
			MailGateway.notify(toString());
		}
	}

	private boolean exists(Person toBeNotified) {
		List<String> existingPersonsLastName = Arrays.asList(new String[] {"Maier", "Fischer", "Huber"});
		return existingPersonsLastName.contains(toBeNotified.getLastName());
	}
}
