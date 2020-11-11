import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Insertar {

	   
	   public static void main(String[] args)  {
	       int a=0;
	       
	        Scanner lector = new Scanner(System.in);
	        System.out.println("1. Crear Taula: ");
	        System.out.println("2. Modificar Taula: ");
	        System.out.println("3. Seleccionar la ID de un client: ");
	        System.out.println("4. Seleccionar comanda d'algun client ");
	        System.out.println("5. Eliminar Taula ");



	        System.out.println("¿Quina consulta vols fer?: ");
	        a=lector.nextInt();
	        lector.nextLine();
	        
	        
	        Insertar programa = new Insertar();
	        
	        if (a==1){
	         programa.CrearTaules();

	        }
	        
	        if (a==2){
	            
	        programa.ModificaClient();         
	        }
	        
	        if (a==3){
	            
	        programa.SelectClientID();
	            
	        }
	         if (a==5){
	            
	        programa.DeleteClientID();
	            
	        }
	         if (a==4){
		            
	 	        programa.SelectComandesID();
	 	            
	 	        }
	   }
	   
	   public void CrearTaules(){
	       
	     
	        	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
	    		EntityManager entitymanager = emfactory.createEntityManager();
	    		entitymanager.getTransaction().begin();
	    		
	    	
	    	
	        
	    		Productes productes = new Productes();
		 		productes.setNom("Samsung Smart TV");
		 		productes.setPreu(120000);
		
		 		entitymanager.persist(productes);
		 		
		 		Clients clients = new Clients();
	    		clients.setNom("Sergi");
	    		clients.setAdreça("Lleida");
	    		
	    		Comandes comandes = new Comandes ();
	    		
	    		comandes.setData_comanda("10-12-18");
	    		comandes.setId(0);
	    		
	    		Productes Productes = new Productes ();
	    		
	    		productes.setId(0);
	    		productes.setNom("Samsung");
	    		productes.setPreu(12000);
	    		
	    		entitymanager.persist(clients);		

	    		entitymanager.getTransaction( ).commit( );
	    	
		
		 		entitymanager.close( );
		 		emfactory.close( );
		     
		     
		     
	}//end
	   
	   public void ModificaClient(){
		   int id=0;
		   String nom, adreça, email;
		   int c=0;
	        Scanner lector = new Scanner(System.in);
	        System.out.println("ID Client: ");
	        id=lector.nextInt();
	        lector.nextLine();
	        System.out.println("Introdueix el nom:");
	        nom = lector.nextLine();
	        System.out.println("Introdueix l'adreça:");
	        adreça = lector.nextLine();
	        System.out.println("Introdueix el correu:");
	        email = lector.nextLine();	     
	     
	      
	          
	       try{ 
		   EntityManagerFactory emfactory = Persistence.
		   createEntityManagerFactory( "Eclipselink_JPA" );
		   EntityManager entitymanager = emfactory.
		   createEntityManager( );
		   entitymanager.getTransaction( ).begin( );
		   Clients clients=entitymanager.
		   find(Clients.class, id );
		   //before update
		   System.out.println( clients);
		   clients.setNom(nom) ;
		   clients.setAdreça(adreça) ;

			   entitymanager.getTransaction( ).commit( );
				   entitymanager.close();
				   emfactory.close();
	       }catch(NullPointerException ex){
	    	   
				  System.out.println("No s'ha trobat aquest client");
				  c++;
	       }
	       if(c==0){
				  System.out.println("Client Modificat");

	       }
	      
	}//end
	   
	    public void SelectClientID(){
	    	   int id=0;
		        Scanner lector = new Scanner(System.in);
		        System.out.println("ID Client: ");
		        id=lector.nextInt();
		        
	    	EntityManagerFactory emfactory = Persistence
	    			.createEntityManagerFactory( "Eclipselink_JPA" );
	    			EntityManager entitymanager = emfactory.
	    			createEntityManager();
	    			   Clients clients=entitymanager.
					   find(Clients.class, id);
	    			   System.out.println();
	    			   System.out.println();
	    			   System.out.println();
	    			   System.out.println();

	    			System.out.println(clients.toString());
	    		
	}
	    
	     public void DeleteClientID(){
	    	  int id=0,c=0;
		        Scanner lector = new Scanner(System.in);
		        System.out.println("ID Client: ");
		        id=lector.nextInt();
		        try{
	    	 EntityManagerFactory emfactory = Persistence.
	    			 createEntityManagerFactory( "Eclipselink_JPA" );
	    			 EntityManager entitymanager = emfactory.
	    			 createEntityManager( );
	    			 entitymanager.getTransaction( ).begin( );
	    			 
	    			 
	    			 
	    			
	    			 
	    			 Productes producte=entitymanager.
	    					   find(Productes.class, id-1);
	    			 entitymanager.remove(producte);

	    			 
	    			 Clients clients=entitymanager.
	    					   find(Clients.class, id);
	    			 entitymanager.remove(clients);
	    			 
	    			 Comandes comandes=entitymanager.
	    					   find(Comandes.class, id+1);
	    			 entitymanager.remove(comandes);
	    			 
	    			 entitymanager.getTransaction( ).commit( );
	    			 entitymanager.close( );
	    			 emfactory.close( ); 
	    			 
	       }catch(NullPointerException ex){
	    	   
					  System.out.println("No s'ha pogut borrar");
					  c++;
		       }
		       if(c==0){
		    	   System.out.println();
		    	   System.out.println();
		    	   System.out.println();

					  System.out.println("Client Borrat");

		       }
	     }
	     
	 	public void SelectComandesID() {
	 		 int id=0;
		        Scanner lector = new Scanner(System.in);
		        System.out.println("ID Client: ");
		        id=lector.nextInt();
		        
	    	EntityManagerFactory emfactory = Persistence
	    			.createEntityManagerFactory( "Eclipselink_JPA" );
	    			EntityManager em = emfactory.
	    			createEntityManager();
	    			
	    			Query query1 = em.
	    					createQuery("Select c from Comandes c where c.clients.id = :id");
	    					query1.setParameter("id", id);
	    					
	    				 

	    					List<Comandes> list = query1.getResultList( );
	    					for( Comandes e:list )	    {
	    						
	    						
	    		    			System.out.println(e.toString());

	    					}
	    	
	    			   
		}
	     
}
