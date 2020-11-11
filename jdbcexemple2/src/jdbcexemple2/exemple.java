package jdbcexemple2;

import java.sql.*;

public class exemple {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/animal";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Connection conn = null;
	Statement stmt = null;
	try {
	    Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	    //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT * FROM animal";
	      ResultSet rs = stmt.executeQuery(sql);
	      
	      while(rs.next()) {		  
		  
		  int id = rs.getInt("Id");
		  String nom = rs.getString("name");
		  String categoria = rs.getString("category");
		  
		  System.out.println("ID = " + id + " , nom = " + nom + ", categoria = "
			  + categoria);
	      
	      }
	      rs.close();
	      stmt.close();
	      conn.close();
	
	
	}
	catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }
	catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
	finally {
	  //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	    
	}
	   
    }

}
