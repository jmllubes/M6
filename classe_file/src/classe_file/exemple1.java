package classe_file;

import java.io.File;
import java.io.IOException;

public class exemple1 {

    
    public static void main(String[] args) throws IOException {
	String str = "nom.txt";
	File ruta = new File("C:\\Users\\Usuari\\DAM2018-19\\classe_file");
	File f = new File (str);
	
	System.out.println(f.getName());
	System.out.println(f.getAbsolutePath());
	System.out.println(f.getCanonicalPath());
	System.out.println(f.length());
	System.out.println(f.isFile());
	String[] llista = ruta.list();
	
	for (String z : llista) {
	    
	    File b = new File(z);
	    if(b.isFile()) {
		System.out.println(b.getName());
	    }
	
	
	}
	
	
	
	
	  /* int a = 0;
	    while (f.exists()) {
		a = a + 1;
		String[] nom =str.split("\\.");
		str= nom[0]  + a + "." + nom[1];
		File f1 = new File (str);
		f.renameTo(f1);
	    }
		f.createNewFile();*/
	
	
	
	

	}
    
}
