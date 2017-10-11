package org.astrumit.StatischeAbhaengigkeit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.function.Consumer;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

public class PersonServiceTest {

	@Test
	public void It_notifies_a_person_when_it_exists() {
		Consumer<Person> notify = mock(Consumer.class);
		
		PersonService sut = new PersonService(notify);
		Person person = new Person("Hans", "Peter");
		sut.setExistingPersons(Arrays.asList(person ));
		
		sut.notifyIfExists(person);
		
		verify(notify).accept(person);
	}

}
