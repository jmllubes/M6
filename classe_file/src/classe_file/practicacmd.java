package classe_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class practicacmd {
	public static void main(String[] args) throws IOException {
		
	    practicacmd inicial = new practicacmd();
		inicial.inici();
	}
	public void inici() {
		informacio();
		bucle();
	}
	void informacio() {
		System.out.println("Les comandes que es poden utilitzar són les següents.");
		System.out.println("1. 'cd'.");
		System.out.println("2. 'mkdir'.");
		System.out.println("3. 'dir'.");
		System.out.println("4. 'del'.");
		System.out.println("5. 'rename'.");
		System.out.println("6. 'exit'.");
		System.out.println("---------------------------------------------------------");
	}
	void bucle() {
		Scanner sc = new Scanner(System.in);
		String comanda = "";
		
		System.out.print("Microsoft Windows [Versión 10.0.18362.356]\r\n" + 
				"(c) 2019 Microsoft Corporation. Todos los derechos reservados.\n");
		
		System.out.print("\nC:\\Users\\Usuari\\DAM2018-19\\classe_file> ");
		// cd ruta
		comanda = sc.nextLine();
		String[] comandes = comanda.split(" ", 2);
		String ruta = "C:\\Users\\Usuari\\DAM2018-19\\classe_file";
		// Primer element array és la comanda. El segon és ruta, nom arxiu, etc.
		
		while(!comandes[0].equals("exit")) {
			
			File path = new File(ruta);
			
			if(comandes[0].equals("cd")) {
				
		// Si passa dintre del IF s'obtindrà la ruta.
				
				ruta = comandes[1];
				path = new File(ruta);
			}
			
			if(comandes[0].equals("mkdir")) {
				File c = new File(ruta, comandes[1]);
								
				if(c.mkdir()) {
					System.out.println("Fitxer creat.");
				} else {
					System.out.println("No se ha pogut crear.");
				}	
			}
			
			if(comandes[0].equals("dir")) {
				File directori = new File(ruta);
				String[] fitxers = directori.list();
				int directoris = 0;
				int arxius = 0;
				long bytes = 0;
				for(int i = 0; i < fitxers.length; i++) {
					
					File f = new File(ruta, fitxers[i]);
					
					if(f.isDirectory()) {
						directoris++;
						SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
						System.out.println(date.format(f.lastModified())+"   <DIR>        "+fitxers[i]);
						
					} else {
						arxius++;
						SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
						System.out.println(date.format(f.lastModified())+"            "+f.length()+"    "+fitxers[i]);
						bytes = bytes + f.length();
					}
				}
				System.out.println("          "+arxius+" fitxers — "+bytes+" bytes.");
				System.out.println("          "+directoris+" directoris.");
			}
			
			if(comandes[0].equals("del")) {
				File el = new File(ruta, comandes[1]);
				if(el.delete()) {
					System.out.println("S'ha pogut eliminar.");
				}else {
					System.out.println("No s'ha pogut eliminar o no existeix.");
				}
			}
			
			 if(comandes[0].equals("rename")) {
				 String[] Nomdesti = comandes[1].split(" ");
				String origen = ruta + "\\" + Nomdesti[0];
				String fin = ruta + "\\" + Nomdesti[1];
				File oldfile = new File(origen);
				File newfile = new File(fin);
				
				if(oldfile.renameTo(newfile)) { 
					System.out.println("Nom canviat correctament.");
				} else {
					System.out.println("El nom no s'ha pogut canviar.");
				}
				
				
			}
			 
			 
			
			
			// Es repeteix el procès
			
			System.out.print("\n"+ruta+"> ");
			comanda = sc.nextLine();
			 comandes = comanda.split(" ", 2);
		}
	}
}
