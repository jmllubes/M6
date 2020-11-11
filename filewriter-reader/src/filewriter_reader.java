import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class filewriter_reader {
    public static void main(String[] args) throws IOException {
    
	FileWriter fw = new FileWriter("hola.txt");
	
	fw.write("hola");
	fw.close();
	
	FileReader fr = new FileReader("hola.txt");
	File f = new File("hola1.txt");
	fw = new FileWriter(f);
	
	int c = fr.read();
	int cont = 0 ;
	while (c != -1) {
	    
	    if (c == 'a' || c =='e' || c == 'o' || c == 'u') {
		c = 'i';
	    }
	    System.out.print((char)c);
	    fw.write(c);
	    c = fr.read();
	}
	fw.close();
	fr.close();
	File fw2 = new File("hola.txt");
	fw2.delete();
	File fw1 = new File("hola.txt");	
	f.renameTo(fw1);
	
    }
}
