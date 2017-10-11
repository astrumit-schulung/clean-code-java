public class PersonService
{
  private PersistenceContext persistence;

  public PersonService(PersistenceContext persistence)
  {
    this.persistence = persistence;
  }

  public void addPerson(Person personToAdd)
  {
    persistence.save(personToAdd);
  }
}