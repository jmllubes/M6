package jpa_exemple;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class create_employee {

    public static void main(String[] args) {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa_exemple");
	EntityManager entitymanager = emfactory.createEntityManager();
	entitymanager.getTransaction().begin();
	/*Employee employee = new Employee();
	employee.setEid(1201);
	employee.setEname("Gopal");
	employee.setSalary(40000);
	employee.setDeg("Technical Manager");
	entitymanager.persist(employee);
	entitymanager.getTransaction().commit();*/
	
	Query query = entitymanager.createQuery("Select e from Employee e");
	
	List<Employee> list=query.getResultList();
	
	for(Employee a:list) {
	    
	    System.out.println(a.toString());
	    
	}
	
	entitymanager.close();
	emfactory.close();
    }
}
