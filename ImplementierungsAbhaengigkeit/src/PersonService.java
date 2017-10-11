public class PersonService
{
  private PersistenceContext persistence = new PersistenceContext();

  public void addPerson(Person personToAdd)
  {
    persistence.save(personToAdd);
  }
}