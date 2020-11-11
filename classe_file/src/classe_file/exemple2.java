package classe_file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class exemple2 {

    public static void main(String[] args) throws IOException {

	Scanner sc = new Scanner(System.in);
	String nom;

	System.out.println("Introdueix el nom del fitxer a eliminar");
	nom = sc.next();

	File f = new File(nom);

	if (f.exists()) {

	    if (f.delete()) {
		System.out.println("borrat");
	    }
	} else {

	    if (f.createNewFile()) {
		System.out.println("fitxer creat");
	    }
	}

    }

}
