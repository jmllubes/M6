package practica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class examen {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	ArrayList<ticket> llistat = new ArrayList<ticket>();
	ArrayList<producte> llistap = new ArrayList<producte>();

	Scanner scan = new Scanner(System.in);
	try {
	    File f = new File("ticket.dat");
	    if (f.exists()) {
		FileInputStream fis = new FileInputStream("ticket.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		while (fis.available() != 0) {
		    ticket t = (ticket) ois.readObject();
		    llistat.add(t);
		}
		ois.close();
		fis.close();
	    }

	    int a = 0;
	    while (a != 3) {
		System.out.println("1 - Insertar atributs producte i ticket: ");
		System.out.println("2 - Mostrar atributs producte");
		System.out.println("3 - Modificar atributs ticket");

		a = scan.nextInt();
		scan.nextLine();

		if (a == 1) { // Insertar

		    try {
			FileInputStream fisp = new FileInputStream("productes.dat");
			ObjectInputStream oisp = new ObjectInputStream(fisp);
			while (fisp.available() != 0) {
			    producte p = (producte) oisp.readObject();
			    llistap.add(p);
			    System.out.println(p.toString());
			}
			oisp.close();
			fisp.close();

			System.out.println("Quin codi de producte vols?");
			int b = scan.nextInt();
			scan.nextLine();
			producte c = new producte();
			for (producte prod : llistap) {
			    if (prod.getCodi() == b) {
				c = prod;
			    }
			}
			System.out.println("Entra el codi ticket:  ");
			int codi_ticket = scan.nextInt();
			System.out.println("Entra el nom del empleat:  ");
			String nom_empleat = scan.nextLine();
			System.out.println("Entra la data del ticket:  ");
			String data_ticket = scan.nextLine();

			ticket t = new ticket(nom_empleat, codi_ticket, data_ticket, c);

			if (a == 2) {
			    for (ticket tic : llistat) {
				System.out.println(tic.toString());
			    }

			}
			FileOutputStream fos = new FileOutputStream("productes.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (producte prod : llistap) {
			    oos.writeObject(prod);
			}
			oos.close();
			fos.close();
		    } catch (Exception e) {
			// TODO: handle exception
		    }

		}

	    }
	} catch (Exception e) {
	    // TODO: handle exception
	}

    }
}
