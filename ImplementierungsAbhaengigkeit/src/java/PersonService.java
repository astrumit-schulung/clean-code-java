public class PersonService
{
  private IPersistenceContext persistence;

  public PersonService(IPersistenceContext persistence) {
	  this.persistence = persistence;
  }
  
  public void addPerson(Person personToAdd)
  {
    persistence.save(personToAdd);
  }
}