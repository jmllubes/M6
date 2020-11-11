import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateEmployee {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	EntityManagerFactory emfactory = Persistence.
		createEntityManagerFactory( "primer JPA" );
	EntityManager entitymanager = emfactory.
		createEntityManager( );
	entitymanager.getTransaction( ).begin( );
	
	Employee loquevulguis = new Employee( "Albert", 1225.50 , "Developer");
	
	entitymanager.persist(loquevulguis);
	entitymanager.getTransaction().commit();
	
	entitymanager.close();
	emfactory.close();
    }

}
