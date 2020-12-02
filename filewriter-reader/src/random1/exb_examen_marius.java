package random1;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class exb_examen_marius {

    // Marius Mihai Urcan - ex 2B EXAMEN ACCES DADES

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String Nom_persona;
	String Nom_personaNOU, cadena;

	long pos = 0;
	int indice;
	StringBuilder auxBuilder;

	try {

	    // create a new RandomAccessFile with filename test
	    RandomAccessFile fichero = new RandomAccessFile("noms.txt", "rw");

	    System.out.println("Entra el nom d'una persona: ");
	    Nom_persona = scan.nextLine();

	    // escriu al fitxer
	    fichero.writeBytes(Nom_persona);

	    // posar la posicio 0
	    fichero.seek(0);

	    // print el string
	    System.out.println("-Nom de la persona: " + fichero.readUTF());

	    System.out.println("----------------");

	    System.out.println("Entra el nom d'una persona que busques: ");
	    Nom_personaNOU = scan.nextLine();

	    fichero.seek(0);

	    // lectura del fichero
	    cadena = fichero.readLine();// leemos la primera línea
	    System.out.println(cadena);
	    if (cadena != null) { // mientras no lleguemos al final del fichero

		indice = cadena.indexOf(Nom_personaNOU); // buscamos la palabra en la línea leída
		System.out.println(indice);
		if (indice != -1) { // mientras la línea contenga esa palabra (por si está repetida

		    // paso la línea a un StringBuilder para modificarlo
		    auxBuilder = new StringBuilder(cadena);

		    auxBuilder.replace(indice, indice + Nom_persona.length(), "");

		    cadena = auxBuilder.toString();
		    System.out.println(cadena);
		    fichero.seek(0);
		    
		    fichero.writeBytes(cadena);

		}

	    }

	} catch (FileNotFoundException ex) {
	    System.out.println(ex.getMessage());
	} catch (IOException ex) {
	    System.out.println(ex.getMessage());
	} finally {
	}
    }

}
