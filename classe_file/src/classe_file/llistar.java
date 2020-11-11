package classe_file;

import java.io.File;

public class llistar {

    public static void main(String[] args) {
	String ruta = "C:\\Users\\Usuari\\Desktop";
        File directorio = new File(ruta);
        String[] lista = directorio.list();
        for (int i = 0; i < lista.length; i++) {
            File f1 = new File (directorio , lista[i]);
            if (f1.isFile()) {
        	System.out.println("FITXER");
        	System.out.println(lista[i]);
            }
            else {
        	System.out.println("CARPETA");
        	System.out.println(lista[i]);
            }
            
        }

    }
}
    

