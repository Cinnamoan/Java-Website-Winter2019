package webd4201.carlosi;

import java.sql.*;

/**
 * This class will be used to connect to the webd4201_db PostGreSQL database
 * and manage database connectivity (opening and closing connections).
 * 
 * @author Ian Carlos
 * @version 1.0 (2019/1/28)
 * @since 1.0
 */
public class DatabaseConnect {
    
    /**
     * Defines the database location.
     */
    static String url = "jdbc:postgresql://127.0.0.1:5432/webd4201_db";
    
    /**
     * Connection object to open port to the database.
     */
    static Connection aConnection;
    
    /**
     * Defines the database user.
     */
    static String user = "webd4201_admin";
    
    /**
     * Defines the database password.
     */
    static String password = "webd4201_password";
    
    /**
     * 
     * This method will attempt to establish a connection to the database.
     * 
     * @return Connection to the webd4201_db database 
     */
    public static Connection initialize() {
	try { 	
            
            Class.forName("org.postgresql.Driver"); // loads the JDBC Driver for PostGreSQL
            aConnection = DriverManager.getConnection(url, user, password); // creates the database connection instance
            
	    	
	} catch (ClassNotFoundException e) {  //will occur if you did not import the PostGreSQL *.jar file with drivers
		
            // Print error message
            System.out.println(e);
            
	} catch (SQLException e) {  //any other database exception (misnamed db, misnamed user, worng password, etc)
            
            // Print error message
            System.out.println(e); 
            
        }
	
        // Return the connection object
        return aConnection;
        
	}

	/**
	 * This method will close the connection to the database.
	 */
	public static void terminate()
	{
            try {
                
                // Try to close the connnection.
                aConnection.close();
                
            } catch (SQLException e) { // If failed to close the connection,
                
                // Print error message
                System.out.println(e);	
            }
	} 
}
