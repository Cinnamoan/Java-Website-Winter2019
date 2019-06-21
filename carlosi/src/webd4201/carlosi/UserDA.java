package webd4201.carlosi;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.security.*;


/**
 *
 * Contains all the CRUD methods for the User class and its attributes.
 * 
 * @author Ian Carlos
 * @version 1.0 (2019/03/18)
 * @since 1.0
 */
public class UserDA {
    
    // Declare variables for the database connection
    
    /**
     * Static connection object used for database connection. 
     */
    static Connection aConnection;
    
    /**
     * Static statement object used for database connection.
     */
    static Statement aStatement;
    
    // Declare static variables for all User instance attribtutes.
    
    static User aUser;
    
    /**
     * Static variable for User id instance attribute.
     */
    static long id;
    
    /**
     * Static variable for User password instance attribute.
     */    
    static String password;
    
    /**
     * Static variable for User firstName instance attribute.
     */
    static String firstName;

    /**
     * Static variable for User lastName instance attribute.
     */
    static String lastName;
    
    /**Static variable for User emailAddress instance attribute.
     * 
     */
    static String emailAddress;
    
    /**
     * Static variable for User lastAccess instance attribute.
     */
    static Date lastAccess;
    
    /**
     * Static variable for User enrolDate instance attribute.
     */
    static Date enrolDate;
    
    /**
     * Static variable for User type instance attribute.
     */
    static char type;
    
    /**
     * values.
     */
    static boolean enabled;
    
    /**
     * This method will be used to establish a database connection, takes 
     * a Connection object as an argument, and throws an SQLException error.
     * 
     * @param c connection object
     */
    public static void initialize(Connection c) {
        
        try {
            
            aConnection = c;
            aStatement = aConnection.createStatement();
            
        } catch (SQLException e) {
            
            System.out.println(e);
            
        }
    }

    /**
     * This method will be used to close the database connection, does not take
     * any arguments, and throws an SQLException error.
     */
    public static void terminate() {
        
        try {
            
            aStatement.close();
            
        } catch(SQLException e) {
            
            System.out.println(e);
            
        }
    }
    
 /**
     * 
     * This method will be attempt to create a User object and store it in
     * the database, takes in a User object argument, and throws two exceptions:
     * DuplicateException, InvalidUserDataException
     * 
     * @param aUser takes a User object args
     * @return isInserted - insertion success flag
     * @throws DuplicateException if the user already exists in the database
     * @throws InvalidUserDataException  if passed data is invalid
     * @throws NoSuchAlgorithmException if there are any error encountered about hashing
     * @throws SQLException if there any general SQL errors encountered 
     */
    public static boolean create(User aUser) throws DuplicateException, InvalidUserDataException, NoSuchAlgorithmException, 
            SQLException {
        
        boolean isInserted = false;
        
        id = aUser.getId();
        password = aUser.getPassword();
        firstName = aUser.getFirstName();
        lastName = aUser.getLastName();
        emailAddress = aUser.getEmailAddress();
        lastAccess = aUser.getLastAccess();
        enrolDate = aUser.getEnrolDate();
        enabled = aUser.isEnabled();
        type = aUser.getType();
        
        try {
            
            retrieve(id);
            
            throw (new DuplicateException("Problem with creating a User "
                    + "record, ID " + id +" already exists in the system."));
           
        } catch (NotFoundException e) {
            
            try {

                System.out.println("Before password is hashed: " + password);

                String hashedPassword = hashThePassword(password);
                
                // Prepared Statements help prevent SQL injection!!
                String sqlCreate1 = "INSERT INTO users(id, password, firstName, "
                                + "lastName, emailAddress, lastAccess, "
                                + "enrolDate, enabled,  type) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
                System.out.println(sqlCreate1);              
                
                PreparedStatement CREATE_STMT1 = aConnection.prepareStatement(sqlCreate1);
                CREATE_STMT1.setLong(1, id);
                CREATE_STMT1.setString(2, hashedPassword);
                CREATE_STMT1.setString(3, firstName);
                CREATE_STMT1.setString(4, lastName);
                CREATE_STMT1.setString(5, emailAddress);
                CREATE_STMT1.setDate(6, new java.sql.Date(lastAccess.getTime()));
                CREATE_STMT1.setDate(7, new java.sql.Date(enrolDate.getTime()));
                CREATE_STMT1.setBoolean(8, enabled);
                CREATE_STMT1.setString(9, String.valueOf(type));
                
                isInserted = CREATE_STMT1.execute();
                
            } catch (SQLException er) {
                
                System.out.println(er);             
            } 
            
            
        }
        return isInserted;
        
    }
    
    /**
     * This method will attempt to retrieve a User record by accepting a long
     * argument, and throws NotFoundException and InvalidUserDataException errors.
     * 
     * @param possibleId takes a long args
     * @return aUser object
     * @throws NotFoundException if the user is not found in the database
     * @throws SQLException if there are any general SQL errors encountered
     */
    public static User retrieve(long possibleId) throws NotFoundException, SQLException
	{ // retrieve Customer and Boat data
		aUser = null;
		// define the SQL query statement using the phone number key
		String sqlQuery = "SELECT ?, ?, ?, ?, ?, ?, ?, ?,? FROM users";
                //System.out.println(sqlQuery);
	 	// execute the SQL query statement
                
                PreparedStatement RETRIEVE_STMT = aConnection.prepareStatement(sqlQuery);
                RETRIEVE_STMT.setString(1, "id");
                RETRIEVE_STMT.setString(2, "password");
                RETRIEVE_STMT.setString(3, "firstName");
                RETRIEVE_STMT.setString(4, "lastName");
                RETRIEVE_STMT.setString(5, "emailAddress");
                RETRIEVE_STMT.setString(6, "lastAccess");
                RETRIEVE_STMT.setString(7, "enrolDate");
                RETRIEVE_STMT.setString(8, "enabled");
                RETRIEVE_STMT.setString(9, "type");
                          
                               
		try
 		{
                    ResultSet rs = RETRIEVE_STMT.executeQuery();
                    // next method sets cursor & returns true if there is data
                    
//                    boolean gotIt = rs.next();
                    
                    if (rs.next())
                    {	// extract the data
                        id = rs.getLong("id");
                        password = rs.getString("password");
			firstName = rs.getString("firstName");
                        lastName = rs.getString("lastName");
                        emailAddress = rs.getString("emailAddress");
                        lastAccess = rs.getDate("lastAccess");
                        enrolDate = rs.getDate("enrolDate");
                        type = rs.getString("type").charAt(0);
                        enabled = rs.getBoolean("enabled");
                                     			
			// Create User
                        try{
                            aUser = new User(possibleId, password, firstName, 
                                    lastName, emailAddress, lastAccess, 
                                    enrolDate, type, enabled);
                            
                        }catch (Exception e)
                        { System.out.println("Record for " + firstName + " " + lastName + " contains an invalid ID.  Verify and correct.");
                            System.out.println(e);}
                        
                    } else	// nothing was retrieved
                    {throw (new NotFoundException("Problem retrieving User record, ID#" + possibleId + " does not exist in the system."));}
                    rs.close();
	   	}catch (SQLException e)
		{ System.out.println(e);}
                
		return aUser;
	}   
    
   /**
     * This method will attempt to update and store an existing User record, 
     * accepts a User object as an argument, and throws NotFoundException, 
     * InvalidUserDataException errors.
     * 
     * @param aUser takes a User object args
     * @return records
     * @throws NotFoundException if the user does not exist in the database
     */
    public static int update(User aUser) throws NotFoundException {
        
        int records = 0;
        
        id = aUser.getId();
        password = aUser.getPassword();
        firstName = aUser.getFirstName();
        lastName = aUser.getLastName();
        emailAddress = aUser.getEmailAddress();
        lastAccess = aUser.getLastAccess();
        enrolDate = aUser.getEnrolDate();
        enabled = aUser.isEnabled();
        type = aUser.getType();       
        
        try {
            System.out.println("The updated password: " + password  );
            String hashedPassword = hashThePassword(password);

            String sqlUpdate1 = "UPDATE "
            + "users SET password = ?, " 
            + "firstName = ?, " 
            + "lastName = ?, " 
            + "emailAddress = ?, "
            + "lastAccess = ?, "
            + "enrolDate = ?, "
            + "enabled = ?, "
            + "type = ? "        
            + "WHERE id = ?";
            
            
            System.out.println(sqlUpdate1);
            
            PreparedStatement UPDATE_STMT1 = aConnection.prepareStatement(sqlUpdate1);
            UPDATE_STMT1.setString(1, hashedPassword);
            UPDATE_STMT1.setString(2, firstName);
            UPDATE_STMT1.setString(3, lastName);
            UPDATE_STMT1.setString(4, emailAddress);
            UPDATE_STMT1.setDate(5, new java.sql.Date(lastAccess.getTime()));
            UPDATE_STMT1.setDate(6, new java.sql.Date(enrolDate.getTime()));
            UPDATE_STMT1.setBoolean(7, enabled);
            UPDATE_STMT1.setString(8, String.valueOf(type));
            UPDATE_STMT1.setLong(9, id);
            
            // aUser.retrieve(id); // Create method to access DA?
            retrieve(id);
            
            records = UPDATE_STMT1.executeUpdate();
            
        } catch (NotFoundException e) {
            
            throw new NotFoundException("User record with ID #" + id 
            + " cannot be updated, does not exist in the system.");
                       
        } catch (SQLException e) {
            
            System.out.println(e);
            
        }
        
        return records;
        
    }
    
    /**
     * This method will attempt to delete a User record, accepts a User object
     * as an argument, and throws NotFoundException, InvalidUserDataException errors.
     * 
     * @param aUser takes a User object args
     * @return a record
     * @throws NotFoundException if the user cannot be found in the database
     */
    public static int delete(User aUser) throws NotFoundException {
        
        int records = 0;
        
        id = aUser.getId();
        
        try {
           
            PreparedStatement DELETE_STMT = aConnection.prepareStatement("DELETE "
                + "FROM Users WHERE id = ?");
            
            User.retrieve(id);
            
            records = DELETE_STMT.executeUpdate();
            DELETE_STMT.setLong(1, id);
            
        } catch (NotFoundException e) {
            
            throw new NotFoundException("User with ID #" + id + " cannot be "
                    + "deleted, does not exist.");   
            
        } catch (SQLException e) {
            
            System.out.println(e);
            
        }
        
        return records;
        
    }   
     
    /**
     * 
     * This function will hash the password that will be used to compare
     * and validate with other hashed passwords. 
     * 
     * @param aPassword takes a string args
     * @return the hashed password
     */
    public static String hashThePassword(String aPassword) {        
        
        String hashedPassword = null;
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1"); 
            md.update(aPassword.getBytes()); 
            byte[] bytesOfHashedString = md.digest();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < bytesOfHashedString.length; i++) {
                Integer.toHexString(bytesOfHashedString[i]);

                String.format("%20x", bytesOfHashedString[i]);

                sb.append(String.format("%02x", bytesOfHashedString[i])); 

                hashedPassword = sb.toString();
            }

            hashedPassword = sb.toString();

            return hashedPassword;
        } catch (NoSuchAlgorithmException err) {
                System.out.println(err);
            }
        
        return hashedPassword;
    }   
    
}
