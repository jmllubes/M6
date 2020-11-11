package practica;

import java.sql.*;
import java.util.Scanner;

public class practica_jdbc {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/empresa";
   static final String USER = "root";
   static final String PASS = "";
   
  
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   
   Scanner lector = new Scanner(System.in);

   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      stmt = conn.createStatement();
      
      System.out.print("Benvingut/a! Quina acció vols fer?\n");
      System.out.println("1 - Crear taules");
      System.out.println("2 - Insertar");
      System.out.println("3 - Actualitzar");
      System.out.println("4 - Esborrar");
      System.out.println("5 - Buscar per identificador");
      System.out.println("6 - Sortir");
      
      int n = lector.nextInt();
      
      while (n!= 6) {
	  

	  if(n == 1) {
	  
	  System.out.println("Creating table in given database...");
	      
	      
	      String sql = "CREATE TABLE IF NOT EXISTS producte " +
	                   "(prod_num INTEGER not NULL, " +
	                   " descripcio VARCHAR(30), " + 
	                   " PRIMARY KEY ( prod_num ))"; 

	      stmt.executeUpdate(sql);
	      System.out.println("Created table in given database...");	      
	      
	  }
	  
	  if(n == 2) { //INSERTAR
	      
	      System.out.println("A quina taula vols insertar?");
	      System.out.println("1 - Producte");
	      System.out.println("2 - Detall");
	      System.out.println("3 - Comanda");
	      System.out.println("4 - Client");
	      System.out.println("5 - Empleat");
	      System.out.println("6 - Departament");
	      int j = lector.nextInt();
	      
	      if(j==1) {
		  
		  System.out.println("Entra el codi de producte");
		  int codi = lector.nextInt();  
		  lector.nextLine();
		  System.out.println("Entra la descripció del producte");
		  String descripcio = lector.nextLine();
		  
		  PreparedStatement ps = conn.prepareStatement("INSERT INTO producte VALUES (?,?)");
		  ps.setInt(1, codi);
		  ps.setString(2, descripcio);
		  ps.executeUpdate();
		  
	      }
	      
	      if(n == 3) { //ACTUALITZAR
		      
		      System.out.println("A quina taula vols insertar?");
		      System.out.println("1 - Producte");
		      System.out.println("2 - Detall");
		      System.out.println("3 - Comanda");
		      System.out.println("4 - Client");
		      System.out.println("5 - Empleat");
		      System.out.println("6 - Departament");
		      j = lector.nextInt();
		      
		      if(j==1) {
			  System.out.println("Entra el codi de producte");
			  int codi = lector.nextInt();  
			  lector.nextLine();
			  System.out.println("Entra la descripció del producte");
			  String descripcio = lector.nextLine();
			  
			  PreparedStatement ps = conn.prepareStatement("UPDATE producte SET descripcio=? "
			  	+ "WHERE PROD_NUM=?");
			  ps.setString(1, descripcio);
			  ps.setInt(2, codi);
			  ps.executeUpdate();
			  
			  
		      }
	      
	      }
	      
	      if(n == 4) { //ESBORRAR
		      
		      System.out.println("A quina taula vols insertar?");
		      System.out.println("1 - Producte");
		      System.out.println("2 - Detall");
		      System.out.println("3 - Comanda");
		      System.out.println("4 - Client");
		      System.out.println("5 - Empleat");
		      System.out.println("6 - Departament");
		      j = lector.nextInt();
		      
		      if(j==1) {
			  

		      }
	      
	      }
	      
	      if(n == 5) { //MOSTRAR
		      
		      System.out.println("A quina taula vols insertar?");
		      System.out.println("1 - Producte");
		      System.out.println("2 - Detall");
		      System.out.println("3 - Comanda");
		      System.out.println("4 - Client");
		      System.out.println("5 - Empleat");
		      System.out.println("6 - Departament");
		      j = lector.nextInt();
		      
		      if(j==1) {
			  
			  System.out.println("Entra el codi de producte");
			  int codi = lector.nextInt(); 
			  lector.nextLine();
			  
			  PreparedStatement ps = conn.prepareStatement("SELECT * FROM producte p INNER JOIN"
			  	+ "detall d ON p.prod_num = d.prod_num INNER JOIN comanda c ON"
			  	+ "c.com_num = d.com_num INNER JOIN client cl ON"
			  	+ "cl.client_cod = c.client_cod INNER JOIN emp e"
			  	+ "e.emp_no = cl.REPR_COD INNER JOIN dept ON"
			  	+ "dept.dept_NO = e.dept_no");
			  
			  ResultSet r = ps.executeQuery();
			  
			  while (r.next()) {
			      String descripcio1 = r.getString("descripcio"); 
			  }
			  
		      }
	      
	      }
	      

	      
	      
	  }
	  
	  
	  
	  
	      System.out.println("1 - Crear taules");
	      System.out.println("2 - Insertar");
	      System.out.println("3 - Actualitzar");
	      System.out.println("4 - Esborrar");
	      System.out.println("5 - Buscar per identificador");
	      System.out.println("6 - Sortir");
	      
	      n = lector.nextInt();
	  
	  
	  
	  
	  
	  
      }

      
      
      
      
      
      
     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample