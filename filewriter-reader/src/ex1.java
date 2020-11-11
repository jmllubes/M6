import java.io.File;

public class ex1 {
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	try {
	    String r="C:\\Users\\Usuari\\Documents\\curs 2020-21\\DAM\\M6 - Accès a dades\\Fitxers";
	    File f = new File(r);
	    File c = null;
	    String[] llista = f.list();
	for(String a:llista) {
	    System.out.println(a);
	    String[] b = a.split("\\."); 
	    c = new File(r,b[1]);
	    c.mkdir();
	    File ruta= new File(r,a);
	    String nr = r + "\\" + b[1];
	    File novaruta= new File(nr,a);
	    System.out.println(novaruta.getCanonicalPath());

	    ruta.renameTo(novaruta);
	}
	    
	    
	
	    
	} catch (Exception e) {
	    // TODO: handle exception
	}

}
}
