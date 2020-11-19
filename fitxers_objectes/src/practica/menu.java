package practica;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class menu {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	ArrayList<producte> llistap = new ArrayList<producte>();
	Scanner scan = new Scanner(System.in);
	try {
	    File f = new File("productes.dat");
	    if (f.exists()) {
		FileInputStream fis = new FileInputStream("productes.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		while (fis.available() != 0) {
		    producte p = (producte) ois.readObject();
		    llistap.add(p);
		}
		ois.close();
		fis.close();
	    }

	    int a = 0;
	    while (a != 6) {
		System.out.println("1 - Insertar productes");
		System.out.println("2 - Mostrar preu producte");
		System.out.println("3 - Modificar preu producte");
		System.out.println("4 - Mostrar tots els productes");
		System.out.println("5 - Esborrar un producte");
		System.out.println("6 - Sortir");
		a = scan.nextInt();
		scan.nextLine();

		if (a == 1) { // Insertar
		    System.out.println("Entra el nom: ");
		    String nom = scan.nextLine();
		    System.out.println("Entra el preu: ");
		    double preu = scan.nextDouble();
		    scan.nextLine();
		    System.out.println("Entra el codi: ");
		    int codi = scan.nextInt();
		    scan.nextLine();

		    producte p = new producte(nom, codi, preu);
		    llistap.add(p);

		}
		if (a == 2) { // Mostrar preu d'un producte

		    for (producte prod : llistap) {
			System.out.println(prod.getNom());
		    }

		    System.out.println("Entra un nom de producte: ");
		    String nom = scan.nextLine();
		    for (producte prod : llistap) {
			if (prod.getNom().equals(nom)) {
			    System.out.println(prod.getPreu());
			}
		    }

		}
		if (a == 3) { // Modificar preu

		    for (producte prod : llistap) {
			System.out.println(prod.getNom());
		    }

		    System.out.println("Entra un nom de producte: ");
		    String nom = scan.nextLine();
		    System.out.println("Entra el preu del producte: ");
		    double preu = scan.nextDouble();
		    scan.nextLine();
		    for (producte prod : llistap) {
			if (prod.getNom().equals(nom)) {
			    prod.setPreu(preu);
			}
		    }
 
		}
		if (a == 4) { // Mostrar tots els productes
		    for (producte prod : llistap) {
			System.out.println(prod.toString());
		    }
		}
		if (a == 5) { // Eliminar producte
		    for (producte prod : llistap) {
			System.out.println(prod.getNom());
		    }

		    System.out.println("Entra un nom de producte per eliminar: ");
		    String nom = scan.nextLine();
		    for (producte prod : llistap) {
			if (prod.getNom().equals(nom)) {
			    llistap.remove(prod);
			}
		    }
		}
		if (a == 6) { // Sortir
		    System.out.println("Adeu que passis un bon dia!");

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
