package org.astrumit.StatischeAbhaengigkeit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class PersonServiceTest {

	@Test
	public void It_notifies_a_person_when_it_exists() {
		IMailGateway mailGateway = mock(IMailGateway.class);
		PersonService sut = new PersonService(mailGateway);
		Person person = new Person("Hans", "Peter");
		sut.setExistingPersons(Arrays.asList(person ));
		
		sut.notifyIfExists(person);
		
		verify(mailGateway).notify(person);
	}

}
