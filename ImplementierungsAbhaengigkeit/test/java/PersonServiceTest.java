import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;
public class PersonServiceTest {

	@Test
	public void test() {
		IPersistenceContext persistence = mock(IPersistenceContext.class);
		PersonService sut = new PersonService(persistence);
		
		Person person = new Person("Hans", "Peter");
		sut.addPerson(person);
		
		verify(persistence).save(person);
	}
}
