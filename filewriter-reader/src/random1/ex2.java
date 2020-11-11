package random1;

import java.io.*;
import java.util.Iterator;

public class ex2 {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	try {
	    String ruta = "C:\\Users\\Usuari\\Documents\\curs 2020-21\\DAM\\M6 - Accès a dades\\Cargol.txt";
	    String ruta2 = "C:\\Users\\Usuari\\Documents\\curs 2020-21\\DAM\\M6 - Accès a dades\\Cargol2.txt";
	    
	    FileReader fr = new FileReader(ruta);
	    BufferedReader br = new BufferedReader(fr);
	    FileWriter fw = new FileWriter(ruta2);
	    BufferedWriter bw = new BufferedWriter(fw);
	    String linia = br.readLine();
	    while (linia != null) {
		String[] paraules= linia.split(" ");
		StringBuilder input1 = new StringBuilder();
		input1.append(paraules[1]);
	        input1 = input1.reverse();
	        for (int i = 0; i < paraules.length; i++) {
		    if(i==1) {
			bw.write(input1.toString());
			bw.write(" ");
		    }
		    else {
			bw.write(paraules[i]);
			bw.write(" ");
		    }
		}
	        bw.write("\n");
		linia = br.readLine();
		
		
	    }
	    br.close();
	    fr.close();
	    bw.close();
	    fw.close();
	    
	    
	} catch (Exception e) {
	    // TODO: handle exception
	}
    }

}
