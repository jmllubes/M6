package objectfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class main {
	static ArrayList<alumne> arrayal = new ArrayList(); //array dinamica d'objectes de tipus alumne

    public static void main(String[] args) throws IOException, ClassNotFoundException {
	
	File xc = new File("alumnes.dat");
	FileInputStream f1 = new FileInputStream ("alumnes.dat");
	ObjectInputStream o1 = new ObjectInputStream(f1);
	
	if(xc.exists()) {
	    
		while(f1.available()>0) {
		    
		    alumne var_al = (alumne) o1.readObject();
		    
		    if (!var_al.getNom().equals("jaume")) { 
			arrayal.add(var_al); // AFEGEIX A L'ARRAYLIST
		    }
	  
		}
	}
	//-----------------ESCRIURE-------------------
	
	FileOutputStream f = new FileOutputStream("alumnes.dat");
	ObjectOutputStream o = new ObjectOutputStream(f);
	
	System.out.println("ENTRA EL NOM");
	String nom = "jaume"; //canvia i entra valors per teclat
	System.out.println("ENTRA EL DNI");
	String dni = "3443543"; //canvia i entra valors per teclat
	System.out.println("ENTRA EL EDAT");
	int edat = 12; //canvia i entra valors per teclat
	System.out.println("ENTRA EL TLF");
	int tlf = 66225; //canvia i entra valors per teclat
	
	alumne a1 = new alumne(dni,nom,edat,tlf);
	
	o.writeObject(a1);

	o.close();
	f.close();
	//-------------------BUSCAR-------------------
	FileInputStream asd = new FileInputStream ("alumnes.dat");
	ObjectInputStream sdf = new ObjectInputStream(asd);
	
	System.out.println("BUSCA AMB EL NOM");
	
	while(asd.available()>0) {
	    
	    alumne b = (alumne) sdf.readObject();
	    String nom1 = b.getNom();
	    if (nom1.equals("jaume")) {
		System.out.println(b.getTelefon());
	    }
	    
	    
	}
	asd.close();
	sdf.close();
	
	FileInputStream fis = new FileInputStream ("alumnes.dat");
	ObjectInputStream ois = new ObjectInputStream(fis);
	
	arrayal.clear();
	
	
	//-------------ELIMINAR-----------
	System.out.println("ENTRA AMB EL NOM DEL ALUMNE PER ELIMINAR");

	
	while(fis.available()>0) {
	    
	    alumne var_al = (alumne) ois.readObject();
	    
	    if (!var_al.getNom().equals("jaume")) { 
		arrayal.add(var_al); // AFEGEIX A L'ARRAYLIST
	    }
  
	}
	
	ois.close();
	fis.close();
	
	FileOutputStream foss = new FileOutputStream("alumnes.dat");
	ObjectOutputStream ouss = new ObjectOutputStream(foss);
	
	
	for(int as=0; as < arrayal.size() ; as++) { //BUCLE PER RECORRER ARRAYLIST
	    
	    alumne bvg = arrayal.get(as); // ACCEDEIXO ALUMNE PER ALUMNE DEL ARRAYLIST
	    ouss.writeObject(bvg);
	    
	}
	
	ouss.close();
	foss.close();
	
	
	/*
	 * FileOutputStream f = new FileOutputStream ("client.dat", true);
	 * ObjectOutputStream o = new ObjectOutputStream(f);
	 * 
	 * client c = new client("hola","hola");
	 * 
	 * o.writeObject(c);
	 * 
	 * o.close(); f.close();
	 */
/*
	FileInputStream asd = new FileInputStream ("alumnes.dat");
	ObjectInputStream sdf = new ObjectInputStream(asd);
	
	ArrayList<alumne> arrayal = new ArrayList();
	
	while (asd.available()>0) {
	    
	    alumne var = (alumne) sdf.readObject();
	    arrayal.add(var);
	}
	
	for(int f=0;f<arrayal.size();f++) {
	    alumne m = arrayal.get(f);
	    m.setEdat(14);
	}
	
	FileOutputStream f = new FileOutputStream("alumnes.dat");
	ObjectOutputStream o = new ObjectOutputStream(f);

	
	
	
	alumne a1 = new alumne("4548dsf", "Joan", 17, 45435435);
	alumne a2 = new alumne("54645sfdg", "jaume", 37, 435345);
	alumne a3 = new alumne();
	a3.setDNI("4354645H");
	a3.setEdat(13);
	a3.setNom("Josep");
	a3.setTelefon(465465455);
	
	arrayal.add(a1);

	o.writeObject(a1);
	o.writeObject(a2);
	o.writeObject(a3);

	o.close();
	f.close();

	
	
	
	*/
	
	
	
	
	/*FileInputStream i = new FileInputStream("alumnes.dat");
	ObjectInputStream oi = new ObjectInputStream(i);

	while (i.available() > 0) {
	    
	    alumne r = (alumne) oi.readObject();
	    String hola = r.getDNI();
	    if (hola.equals("123")){
		r.get
	    }
	    
	}
	
	
	
	
	
	
	
	
	
	ArrayList<alumne> coches = new ArrayList();
	while (i.available() > 0) {

	    alumne a = (alumne) oi.readObject();
	    if (a.getNom().equals("Joan")) {
		a.setEdat(24);
	    }
	    coches.add(a);

	}

	oi.close();
	i.close();

	f = new FileOutputStream("alumnes1.dat");
	o = new ObjectOutputStream(f);

	for(int i1 = 0; i1< coches.size(); i1++) {
	    alumne b = coches.get(i1);
	    if (b.getNom().equals("Joan")) {
		b.setEdat(23);
	    }
	    o.writeObject(b);
	}
	

	o.close();
	f.close();

	i = new FileInputStream("alumnes1.dat");
	oi = new ObjectInputStream(i);

	while (i.available() > 0) {

	    alumne a = (alumne) oi.readObject();
	    System.out.println(a.toString());

	}*/

    }
}
