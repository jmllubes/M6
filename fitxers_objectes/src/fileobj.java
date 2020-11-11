import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class fileobj {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner scan = new Scanner(System.in);

	/*
	 * ArrayList<persona> llistap = new ArrayList<>(); for (int i = 0; i < 4; i++) {
	 * System.out.println("Entra el nom: "); String nom= scan.nextLine();
	 * System.out.println("Entra el DNI: "); String DNI = scan.nextLine();
	 * System.out.println("Entra la edat: "); int edat=
	 * scan.nextInt();scan.nextLine(); System.out.println("Entra el telefon: "); int
	 * telefon=scan.nextInt();scan.nextLine(); persona p = new
	 * persona(nom,DNI,edat,telefon); llistap.add(p); } for (persona pers : llistap)
	 * { System.out.println(pers.toString()); }
	 */

	try {
	    /*
	     * FileOutputStream fos = new FileOutputStream ("persones.dat");
	     * ObjectOutputStream oos = new ObjectOutputStream(fos); for (int i = 0; i <
	     * llistap.size(); i++) { oos.writeObject(llistap.get(i)); } oos.close();
	     * fos.close();
	     */
	    FileInputStream fis = new FileInputStream("persones.dat");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    ArrayList<persona> llistap = new ArrayList<>();

	    while (fis.available() != 0) {
		persona p = (persona) ois.readObject();
		llistap.add(p);
	    }
	    System.out.println("HOLA");
	    ois.close();
	    fis.close();
	    for (persona per : llistap) {
		System.out.println(per.toString());
	    }
	    for (int i = 0; i < 4; i++) {
		System.out.println("Entra el nom: ");
		String nom = scan.nextLine();
		System.out.println("Entra el DNI: "); 
		String DNI = scan.nextLine();
		System.out.println("Entra la edat: ");
		int edat = scan.nextInt();
		scan.nextLine();
		System.out.println("Entra el telefon: ");
		int telefon = scan.nextInt();
		scan.nextLine();
		persona p = new persona(nom, DNI, edat, telefon);
		llistap.add(p);
	    }
	    FileOutputStream fos = new FileOutputStream ("persones.dat");
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    for (persona per : llistap) {
		oos.writeObject(per);
	    }
	    oos.close();
	    fos.close();
	    

	} catch (Exception e) {
	    // TODO: handle exception
	    System.out.println(e);
	}

    }

}
