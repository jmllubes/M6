package fitxers_text;

import java.io.*;
import java.util.Scanner;

public class borrar_paraules {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner scan = new Scanner(System.in);
	try {
	    FileReader fr = new FileReader ("C:\\fitxers\\hola.txt");
	    
	    int lletra = fr.read();
	    String text = "";
	    while(lletra != -1) {
		text = text + (char)lletra;
		lletra = fr.read();
		
	    }
	    fr.close();
	    System.out.println("Digues la paraula que vols canviar: ");
	    String paraula = scan.nextLine(); //Antonio
	    System.out.println("Digues la paraula nova a reemplaçar: ");
	    String paraula_nova = scan.nextLine(); //Adria
	    
	    if(text.contains(paraula)) {
		text = text.replaceAll(paraula, paraula_nova);
	    }
	    else {
		System.out.print("No s'ha trobat la paraula");
	    }
	    FileWriter fw = new FileWriter("C:\\fitxers\\hola.txt");
	    fw.write(text);
	    fw.close();
	    
	    
	    
	    
	} catch (Exception e) {
	    // TODO: handle exception
	}

    }

}
