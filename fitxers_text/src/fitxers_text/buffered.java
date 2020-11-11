package fitxers_text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class buffered {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner scan = new Scanner(System.in);
	try {
	    FileReader fr = new FileReader("C:\\fitxers\\hola.txt");
	    BufferedReader br = new BufferedReader(
		    new InputStreamReader(new FileInputStream("C:\\fitxers\\hola.txt"), "UTF8"));
	    String linia = br.readLine();
	    while (linia != null) {
		System.out.println(linia);
		linia = br.readLine();
	    }

	    br.close();
	    fr.close();
	    
	    FileWriter fw = new FileWriter("C:\\fitxers\\hola.txt",true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    System.out.println("Entra un nom d'un alumne nou: ");
	    String nom = scan.nextLine();
	    bw.write("\n");
	    bw.newLine();
	    bw.write(nom);
	    
	    bw.close();
	    fw.close();

	} catch (Exception e) {
	    // TODO: handle exception
	}

    }

}
