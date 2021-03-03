package model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Bombero;
import model.Coche;
import model.Equipo;
import model.Parque;
import model.Servicio;


public class menu {

	public static void main(String[] args) throws ParseException {
		Scanner lector = new Scanner(System.in);

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ExamJPA-XavierNavarro");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		boolean s = false;

		while (s == false) {

			System.out.println("Que vols fer:");
			System.out.println("1- Obtindre Bomber");
			System.out.println("2- Registrar Bomber");
			System.out.println("3- Registrar Cotxe");
			System.out.println("4- Registrar Servei");
			System.out.println("5- Sortir");
			System.out.print("Triar opcio: ");

			int a = lector.nextInt();
			System.out.println();

			if (a == 1) {// Obtindre bomber
				System.out.print("Entra ID:");
				int id = lector.nextInt();			
				Bombero bombero = entitymanager.find(Bombero.class,id);
				
				System.out.println(bombero.getNombre());
			}

			if (a == 2) { // Registrar bomber
				System.out.print("Entra ID:");
				int id = lector.nextInt();
				
				System.out.print("Entra parque_id:");
				int id_parque = lector.nextInt();
				
				System.out.print("Entra apellidos:");
				String apellidos = lector.next();
				
				System.out.print("Entra nombre:");
				String nombre = lector.next();
				
				System.out.print("Entra DNI: ");
				String dni = lector.next();
				
				System.out.print("Entra data naixement: ");
				String data = lector.next();
				Date date1= new SimpleDateFormat("dd-MM-yyyy").parse(data);  
				
				System.out.print("Entra direccion: ");
				String direccion = lector.next();
				
				System.out.print("Entra telefono: ");
				String telefono = lector.next();
				
				System.out.print("Entra el ID del servei: ");
				int idservice = lector.nextInt();
				Servicio serv = entitymanager.find(Servicio.class,idservice);
				System.out.println(serv.toString());
				EquipoPK epk = new EquipoPK(idservice,id);
				Equipo e = new Equipo(epk,"netejavidres",serv);
				List<Equipo> le = new ArrayList();

				le.add(e);

				
				Parque parque = entitymanager.find(Parque.class,id_parque);
				Bombero bombero = new Bombero();
				bombero.setId(id);
				bombero.setApellidos(apellidos);
				bombero.setDireccion(direccion);
				bombero.setDni(dni);
				bombero.setEquipos(le);
				bombero.setFechaNacimiento(date1);
				bombero.setNombre(nombre);
				bombero.setTelefono(telefono);
				bombero.setParque(parque);
				e.setBombero(bombero);
				entitymanager.persist(e);

				entitymanager.persist(bombero);

				System.out.println(bombero.toString());
	
				

				entitymanager.getTransaction().commit();
				
			}
			
			
            if (a == 3) { // Registrar cotxe
				
				System.out.print("Entra ID: ");
				int id = lector.nextInt();
				
				System.out.print("Entra parque_id: ");
				int id_parque = lector.nextInt();
				
				System.out.print("Entra marca: ");
				String marca = lector.next();
				
				System.out.print("Entra modelo: ");
				String modelo = lector.next();
				
				System.out.print("Entra matricula: ");
				String matricula = lector.next();
				
				Date data_compra = new Date();
				Date data_revisio = new Date();
				data_revisio.setMonth(data_revisio.getMonth() + 60);
				
				
				Parque parque = entitymanager.find(Parque.class,id_parque);
				
				Coche coche = new Coche(id,data_compra,data_revisio,marca,matricula,modelo,parque);
				entitymanager.persist(coche);
				entitymanager.getTransaction().commit();
            	
			}
			

            if (a == 4) { // Registrar servei
            	
				System.out.print("Entra ID: ");
				int id = lector.nextInt();
				
				System.out.print("Entra parque_id: ");
				int id_parque = lector.nextInt();
				
				
				Date fecha = new Date();
				LocalTime ahora = LocalTime.now();
				String hora= ahora.toString();

				lector.nextLine();
				System.out.print("Entra tipo servicio: ");
				String tipo_servicio = lector.nextLine();
				
				System.out.print("Entra urgencia: ");
				int urgencia = lector.nextInt();
				
				Parque parque = entitymanager.find(Parque.class,id_parque);
				
				Servicio servicio = new Servicio(id,fecha,hora,tipo_servicio,urgencia,parque);
				entitymanager.persist(servicio);
				entitymanager.getTransaction().commit();
            }


			if (a == 5) { // Sortir


				entitymanager.close();
				emfactory.close();
				s = true;
			}

		}

	}

}