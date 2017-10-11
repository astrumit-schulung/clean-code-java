import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PersistenceContext
{

  public final void save(Person newPerson)
  {  
    final String connectionString = "jdbc:msql://200.210.220.1:1114/Demo"; 
    try (Connection conn = DriverManager.getConnection(connectionString,"",""); ){ 
    	Statement st = conn.createStatement(); 
        st.executeUpdate(String.format("INSERT INTO Person (Firstname, Lastname) " + 
            "VALUES ('%s', '%s')", newPerson.getFirstName(), newPerson.getLastName())); 
    } catch (SQLException e) {
		throw new RuntimeException(e);
	}
  }
}