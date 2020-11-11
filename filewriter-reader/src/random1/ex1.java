package random1;

import java.io.File;

public class ex1 {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	String ruta = "C:\\Users\\Usuari\\Documents\\curs 2020-21\\DAM\\M6 - Accès a dades\\Fitxers";
	File f = new File(ruta);
	String[] llista = f.list();
	for (int i = 0; i < llista.length; i++) {
	    //llista[i] = imatge.png
	    String[] nom = llista[i].split("\\.");
	    //["imatge","png"]
	    String rutanova = ruta + "\\" + nom[1];
	    System.out.println(rutanova);
	    //C:\Users\Usuari\Documents\curs 2020-21\DAM\M6 - Accès a dades\Fitxers\png
	    File fn = new File(rutanova);
	    fn.mkdir();
	    File f1 = new File(ruta,llista[i]);
	    File f2 = new File(rutanova,llista[i]);
	    f1.renameTo(f2);
	    
	    
	    

	}
	
	
    }

}
