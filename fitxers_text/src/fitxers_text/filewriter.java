package fitxers_text;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class filewriter {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner scan = new Scanner (System.in);
	try {
	    FileWriter fw = new FileWriter("C:\\fitxers\\hola.txt",true);
	    String frase = scan.nextLine();
	    String[] lletres= frase.split("");
	    String[] vocals = {"a","e","o","u"};
	    fw.write("\n");
	    for(String a:lletres) {
		if(a.equals(vocals[0]) || a.equals(vocals[1] ) || a.equals(vocals[2] )
			|| a.equals(vocals[3] )) {
		    a="i";
		    
		}
		fw.write(a);
	    }	      
	    fw.close();
	    FileReader fr = new FileReader("C:\\fitxers\\hola.txt");
	    int lletra = fr.read();
	    while(lletra != -1) {
		System.out.print((char)lletra);		
		lletra = fr.read();
	    }
	    fr.close();
	    
	    
	} catch (Exception e) {
	    // TODO: handle exception
	}

    }

}
