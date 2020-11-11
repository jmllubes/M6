import java.io.*;

public class ex2 {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	try {

	    FileReader fr = new FileReader(
		    "C:\\Users\\Usuari\\Documents\\curs 2020-21\\DAM\\M6 - Accès a dades\\Cargol.txt");
	    BufferedReader br = new BufferedReader(fr);
	    FileWriter fw = new FileWriter(
		    "C:\\Users\\Usuari\\Documents\\curs 2020-21\\DAM\\M6 - Accès a dades\\Cargol2.txt");
	    BufferedWriter bw = new BufferedWriter(fw);
	    String linia = br.readLine();
	    while (linia != null) {
		String[] paraula = linia.split(" ");
		StringBuffer sbr = new StringBuffer(paraula[1]);
		// To reverse the string
		sbr.reverse();
		System.out.println(linia);

		for (int i = 0; i < paraula.length; i++) {
		    if (i == 1) {
			bw.write(sbr.toString());
			bw.write(" ");

		    } else {
			bw.write(paraula[i]);
			bw.write(" ");

		    }

		}
		bw.write("\n");

		linia = br.readLine();

	    }

	    bw.close();
	    fw.close();
	    br.close();
	    fr.close();
	} catch (Exception e) {
	    // TODO: handle exception
	}
    }

}
