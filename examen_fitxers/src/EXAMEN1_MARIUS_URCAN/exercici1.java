package EXAMEN1_MARIUS_URCAN;

import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class exercici1 {
    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner(System.in);
		
        recorrerDirectorios("/");
    }

    public static void recorrerDirectorios(String ruta) {
        //Se crea un objeto file con la ruta del directorio
        File directorio = new File("C:\\Users\\Usuari\\Documents\\curs 2020-21\\DAM\\M6 - Accès a dades\\Fitxers");
        File fichero=new File("C:\\Users\\marca\\Desktop\\Fitxers.txt");
        File fichero2=new File("C:\\Users\\marca\\Desktop\\Fitxers.pdf");
        File fichero3=new File("C:\\Users\\marca\\Desktop\\Fitxers.mp4");
        File fichero4=new File("C:\\Users\\marca\\Desktop\\Fitxers.png");
        File directorio1=new File("C:\\Users\\Usuari\\Documents\\curs 2020-21\\DAM\\M6 - Accès a dades\\Fitxers\\mp4");
        File directorio2=new File("C:\\Users\\Usuari\\Documents\\curs 2020-21\\DAM\\M6 - Accès a dades\\Fitxers\\pdf");
        File directorio3=new File("C:\\Users\\Usuari\\Documents\\curs 2020-21\\DAM\\M6 - Accès a dades\\Fitxers\\png");
        File directorio4=new File("C:\\Users\\Usuari\\Documents\\curs 2020-21\\DAM\\M6 - Accès a dades\\Fitxers\\txt");
        //Se comprueba si la ruta existe
        if (!directorio.exists()) {
            System.out.println("La ruta " + directorio.getAbsolutePath() + " no existe.");
            return;
        }
        //Se comprueba si es un directorio
        if (!directorio.isDirectory()) {
            System.out.println("La ruta " + directorio.getAbsolutePath() + " no es un directorio");
            return;
        }
        System.out.println(directorio.getAbsolutePath());
        //obtener todo el contenido del directorio
        File[] lista = directorio.listFiles();
        //se recorre el directorio y se muestran primero los archivos
        for (File s : lista) {
            if(s.isFile())
                System.out.println("Archivo ->  " + s.getName());
        }
        //se recorre de nuevo el directorio y se obtienen los subdirectorios
        for (File s : lista) {        
            //Si es un directorio se vuelve a llamar al método
            if (s.isDirectory()) {
                recorrerDirectorios(s.getAbsolutePath());
            }
        }
 
   
		Scanner scan = new Scanner(System.in);
		  
		String a = "";
		System.out.print("C:\\Users\\Usuari\\Documents\\curs 2020-21\\DAM\\M6 - Accès a dades\\Fitxers" + ">");
		do {
			a = scan.nextLine();
			String[] b = a.split(" ");	
			if(b[0].equals("Mkdir")) {
				 
				File c = new File("C:\\Users\\Usuari\\Documents\\curs 2020-21\\DAM\\M6 - Accès a dades\\Fitxers",b[1]);
				
			          if(c.mkdir()) {
			        	  System.out.println("Carpeta creada amb èxit! ");
			          }else {
			        	  System.out.println("La carpeta ja existeix! ");
			          }
			          System.out.print(ruta + ">");
				}/*else if(b[0].equals("Move")) {
					
				        Path FROM = Paths.get("C:\\Users\\marca\\Desktop\\Fitxers");
				        Path TO = Paths.get("C:\\Users\\marca\\Desktop\\Fitxers");

				        CopyOption[] options = new CopyOption[]{
				            StandardCopyOption.ATOMIC_MOVE

				        };
				        
				        Files.Move("C:\\Users\\marca\\Desktop\\Fitxers.txt", TO, "C:\\Users\\marca\\Desktop\\Fitxers\\txt");
				    }*/
				
    }while(!a.equals("exit"));
    }
}


