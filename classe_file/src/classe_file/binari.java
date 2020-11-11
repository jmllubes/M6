package classe_file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class binari {

    public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub

	FileOutputStream fos = new FileOutputStream ("C:\\Users\\Usuari\\Pictures\\photo2.jpg");
	DataOutputStream dos = new DataOutputStream(fos);
	
	FileInputStream fis = new FileInputStream("C:\\Users\\Usuari\\Pictures\\photo.jpg");
	DataInputStream dis = new DataInputStream(fis);
	
	int c = dis.read();
	
	while (c != -1) {
	    dos.write(c);
	    c = dis.read();
	}
	
	dis.close();
	fis.close();
	dos.close();
	fos.close();
	}

}
