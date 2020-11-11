import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class filewriter {
    public static void main(String[] args) throws IOException {
	String ruta = "C:\\Users\\Usuari\\Desktop\\hola.txt";
	FileWriter fw = new FileWriter (ruta , true);
	

	fw.write(65);
	fw.close();
	
	FileReader fr = new FileReader (ruta);
	BufferedReader br = new BufferedReader(fr);
	
	String linea = br.readLine();
	while (linea!= null) {
	    System.out.println(linea);
	    linea = br.readLine();
	}
	
	br.close();
	fr.close();
	
    }

}
