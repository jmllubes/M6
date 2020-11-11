package practicaobj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
	ArrayList<producte> llistap = new ArrayList();
	producte p = new producte("1", "patates", "verdura", "3,5");
	llistap.add(p);
	FileOutputStream fos = new FileOutputStream("obj.dat");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	for (int i = 0; i < llistap.size(); i++) {
	    producte a = (producte) llistap.get(i);
	    if (a.getID().equals("1")) {		
		//codi	    }
	    oos.writeObject(a);
	}
	oos.close();
	fos.close();
	FileInputStream fis = new FileInputStream("obj.dat");
	ObjectInputStream ois = new ObjectInputStream(fis);
	while (fis.available() != 0) {
	    producte c = (producte) ois.readObject();
	    llistap.add(c);
	    System.out.println(c.toString());	
	    }
	ois.close();
	fis.close();
	
	

    }

}
