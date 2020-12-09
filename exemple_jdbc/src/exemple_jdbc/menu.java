package exemple_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class menu {
    static Connection conn = null; // Creo la connexió com a static per a que pugui compartir-se per tots els
				   // metodes
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	int a = 0;
	while (a != 5) {
	    System.out.println("Que vols fer?");
	    System.out.println("1 - Per mostrar");
	    System.out.println("2 - Per insertar");
	    System.out.println("3 - Per actualitzar");
	    System.out.println("4 - Per borrar");
	    System.out.println("5 - Per sortir");

	    a = scan.nextInt();
	    if (a == 1) {
		connectar();
		mostrar();
	    } else if (a == 2) {
		connectar();
		insertar();
	    } else if (a == 3) {
		connectar();
		actualitzar();
	    } else if (a == 4) {
		connectar();
		borrar();
	    } else if (a == 5) {
		System.out.println("Que passis un bon dia , adeu!");
	    } else {
		System.out.println("Error , entra un valor entre 1 i 5");
	    }
	}

    }

    private static void connectar() {
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    String URL = "jdbc:mysql://localhost/empresa";
	    String USER = "root";
	    String PASS = "";
	    conn = DriverManager.getConnection(URL, USER, PASS);
	    System.out.println("Connectat a la BD");
	} catch (Exception e) {
	    // TODO: handle exception
	}
    }

    private static void mostrar() {
	try {
	    String sql = "SELECT c.COM_NUM,cl.NOM,c.client_cod,c.total,cl.adreca FROM comanda as c INNER JOIN client as cl"
		    + " ON c.client_cod = cl.client_cod";
	    Statement stmt = conn.createStatement();
	    ResultSet result = stmt.executeQuery(sql);

	    while (result.next()) {
		System.out.print("COM_NUM: " + result.getInt(1) + "  ");
		System.out.print("CLIENT_COD: " + result.getInt(3) + "  ");
		System.out.print("NOM: " + result.getString(2) + "  ");
		System.out.print("ADREÇA: " + result.getString(5) + "  ");
		System.out.println("TOTAL: " + result.getFloat(4));
	    }

	    conn.close();

	} catch (Exception e) {
	    // TODO: handle exception
	}
    }

    private static void insertar() {

    }

    private static void actualitzar() {

    }

    private static void borrar() {

    }

}
