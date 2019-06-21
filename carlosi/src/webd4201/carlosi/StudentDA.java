package webd4201.carlosi;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.security.*;

/**
 * 
 * Contains all the CRUD methods for the User class and its attributes   
 * 
 * @author Ian Carlos
 * @version 1.0 (2019/1/28)
 * @since 2.0
 */
public class StudentDA {
    
    // Declare variables for the database connection
    
    /**
     * Static connection object used for database connection. 
     */
    static Connection aConnection;
    
    /**
     * Static statement object used for database connection.
     */
    static Statement aStatement;
    
    /**
     * Static Student object used to set and get attributes of a Student. 
     */
    static Student aStudent;
    
    /**
     * Static User object used to set and get attributes of a User.
     */
    static User aUser;
    
    // Declare static variables for all User instance attribtutes.
    
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
     * Static variable for User enabled instance attribute.
     */
    static boolean enabled;
    
    // Declare all static static variables for Student instance attribute values.
    
    /**
     * Static variable for Student programCode instance attribute.
     */
    static String programCode;
    
    /**
     * Static variable for Student programDescription instance attribute.
     */
    static String programDescription;
    
    /**
     * Static variable for Student year instance attribute.
     */
    static int year; 
    
    /**
     * This formatter will be used to format any java.util.Date() object into 
     * a database compatible string.
     */
    private static final SimpleDateFormat SQL_DF = 
            new SimpleDateFormat("yyyy-MM-dd");
    
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
     * This method accepts a long student number and a string password, it will
     * return a Student object if it exists in the database. Throws a NotFound
     * Exception if the student's ID and password combination are not found.
     * Also throws InvalidIdException, InvalidUserDataException and SQLException.
     * 
     * @param possibleId takes a long args
     * @param aPassword takes a string args
     * @return if the student exists in the database or not
     * @throws NotFoundException if the student was not found in the database
     * @throws InvalidIdException if the student ID was not found in the database
     * @throws InvalidUserDataException if the data passed is invalid
     * @throws SQLException if there are any general SQL errors encountered
     */
    public static Student authenticate(long possibleId, String aPassword) 
            throws NotFoundException, InvalidIdException, InvalidUserDataException, SQLException {
        
        aStudent = null;
        
        String sqlQuery = "SELECT u.id, u.password, u.firstName, u.lastName, "
                + "u.emailAddress, u.lastAccess, u.enrolDate, u.enabled,  "
                + "u.type, s.programCode, s.programDesc, s.year FROM users u, "
                + "students s WHERE  u.id = s.id AND u.id = '" +  possibleId + "' AND "
                + "u.password = '" + aPassword +  "'";
        //System.out
        PreparedStatement AUTHENTICATE_STMT = aConnection.prepareStatement(sqlQuery
                        );        
        
        try {
            ResultSet rs = AUTHENTICATE_STMT.executeQuery();           
            
            if(rs.next()) {
                id = rs.getLong("id");
                password = rs.getString("password");
	        firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                emailAddress = rs.getString("emailAddress");
                lastAccess = rs.getDate("lastAccess");
                enrolDate = rs.getDate("enrolDate");
                type = rs.getString("type").charAt(0);
                enabled = rs.getBoolean("enabled");
                programCode = rs.getString("programCode");
                programDescription = rs.getString("programDesc");
                year = rs.getInt("year");        
                
                aStudent = new Student(id, password, firstName, 
                                    lastName, emailAddress, lastAccess, 
                                    enrolDate, type, enabled, programCode, 
                                    programDescription, year);
                
            } else {
                throw (new NotFoundException("The ID and password cannot"
                        + " be found in the database."));
            }
            
            rs.close();
            
        } catch(SQLException e) {
            System.out.println(e);
        }
        
        return aStudent;
    }
    
    /**
     * 
     * A variation of the authenticate method, this method only authenticates
     * the current password field in the changepassword.jsp page. Throws a NotFound
     * Exception if the student's ID and password combination are not found.
     * Also throws InvalidIdException, InvalidUserDataException and SQLException.
     * 
     * @param aPassword takes a string args
     * @return if the password exists in the database or not
     * @throws NotFoundException if the student was not in the database
     * @throws InvalidIdException if the student's ID is invalid
     * @throws InvalidUserDataException if the data passed is invalid
     * @throws SQLException if there are any general SQL errors encountered
     */
    public static Student authenticate_password(String aPassword) 
            throws NotFoundException, InvalidIdException, InvalidUserDataException, SQLException {
        
        aStudent = null;
        
        String sqlQuery = "SELECT u.id, u.password, u.firstName, u.lastName, "
                + "u.emailAddress, u.lastAccess, u.enrolDate, u.enabled,  "
                + "u.type, s.programCode, s.programDesc, s.year FROM users u, "
                + "students s WHERE u.password = '" + aPassword +  "'";
        //System.out
        PreparedStatement AUTHENTICATE_STMT = aConnection.prepareStatement(sqlQuery
                        );        
        
        try {
            ResultSet rs = AUTHENTICATE_STMT.executeQuery();           
            
            if(rs.next()) {
                id = rs.getLong("id");
                password = rs.getString("password");
	        firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                emailAddress = rs.getString("emailAddress");
                lastAccess = rs.getDate("lastAccess");
                enrolDate = rs.getDate("enrolDate");
                type = rs.getString("type").charAt(0);
                enabled = rs.getBoolean("enabled");
                programCode = rs.getString("programCode");
                programDescription = rs.getString("programDesc");
                year = rs.getInt("year");      
                
                aStudent = new Student(id, password, firstName, 
                                    lastName, emailAddress, lastAccess, 
                                    enrolDate, type, enabled, programCode, 
                                    programDescription, year);
                
            } else {
                throw (new NotFoundException("The password cannot"
                        + " be found in the database."));
            }
            
            rs.close();
            
        } catch(SQLException e) {
            System.out.println(e);
        }
        
        return aStudent;
    }

    
    /**
     * 
     * This method will be attempt to create a Student object and store it in
     * the database, takes in a Student object argument, and throws two exceptions:
     * DuplicateException, InvalidUserDataException
     * 
     * @param aStudent takes a Student object args
     * @return isInserted - insertion success flag
     * @throws DuplicateException if a student record already exists
     * @throws InvalidUserDataException if passed data is invalid
     * @throws SQLException if any general SQL errors encountered
     */
    public static boolean create(Student aStudent) throws DuplicateException, InvalidUserDataException,
            SQLException {
        
        boolean isInserted = false;
        
        id = aStudent.getId();
//        password = aStudent.getPassword();
//        firstName = aStudent.getFirstName();
//        lastName = aStudent.getLastName();
//        emailAddress = aStudent.getEmailAddress();
//        lastAccess = aStudent.getLastAccess();
//        enrolDate = aStudent.getEnrolDate();
//        enabled = aStudent.isEnabled();
//        type = aStudent.getType();
        programCode = aStudent.getProgramCode();
        programDescription = aStudent.getProgramDescription();
        year = aStudent.getYear();
        
        try {
            
            retrieve(id);
            
            throw (new DuplicateException("Problem with creating a Student "
                    + "record, ID " + id +" already exists in the system."));
           
        } catch (NotFoundException e) {
            
            try {

                System.out.println("Before password is hashed: " + password);

                String hashedPassword = hashThePassword(password);
                /*
                String sqlCreate1 = "INSERT INTO users(id, password, firstName, "
                                + "lastName, emailAddress, lastAccess, "
                                + "enrolDate, enabled,  type) values ('"+ id +"', "
                                + "'"+ hashedPassword +"'"
                                + ", '"+ firstName +"', '"+ lastName +"', "
                                + "'"+ emailAddress +"', '"+ lastAccess +"', "
                                + "'"+ enrolDate +"', '"+ enabled +"', "
                                + "'"+ type +"')";
                
                String sqlCreate2 = "INSERT INTO students("
                        + "id, programCode, programDesc, year) values ('"+ id +"',"
                        + " '"+ programCode +"', '"+ programDescription +"', "
                        + "'"+ year +"')";
                */
                
                // Prepared Statements help prevent SQL injection!!
                String sqlCreate2 = "INSERT INTO students("
                        + "id, programCode, programDesc, year) values (?, ?, ?, ?)";
                
                System.out.println(sqlCreate2);                
                
//                PreparedStatement CREATE_STMT1 = aConnection.prepareStatement(sqlCreate2);
//                CREATE_STMT1.setLong(1, id);
//                CREATE_STMT1.setString(2, hashedPassword);
//                CREATE_STMT1.setString(3, firstName);
//                CREATE_STMT1.setString(4, lastName);
//                CREATE_STMT1.setString(5, emailAddress);
//                CREATE_STMT1.setDate(6, new java.sql.Date(lastAccess.getTime()));
//                CREATE_STMT1.setDate(7, new java.sql.Date(enrolDate.getTime()));
//                CREATE_STMT1.setBoolean(8, enabled);
//                CREATE_STMT1.setString(9, String.valueOf(type));
                
                
                PreparedStatement CREATE_STMT2 = aConnection.prepareStatement(sqlCreate2);
                CREATE_STMT2.setLong(1, id);
                CREATE_STMT2.setString(2, programCode);
                CREATE_STMT2.setString(3, programDescription);
                CREATE_STMT2.setInt(4, year);
                
//                isInserted = CREATE_STMT1.execute();
                isInserted = CREATE_STMT2.execute();
                
            } catch (SQLException er) {
                
                System.out.println(er);
//                System.out.println(id);               
            } 
            
            
        }
        return isInserted;
        
    }
    
    /**
     * This method will attempt to retrieve a Student record by accepting a long
     * argument, and throws NotFoundException and InvalidUserDataException errors.
     * 
     * @param possibleId takes a long args
     * @return aStudent object
     * @throws NotFoundException if the student ID is not found in the database
     */
    public static Student retrieve(long possibleId) throws NotFoundException
	{ // retrieve Customer and Boat data
		aStudent = null;
		// define the SQL query statement using the phone number key
		String sqlQuery = "SELECT u.id, s.programCode, s.programDesc, "
                                  + "s.year FROM users u, students s WHERE  "
                                  + "u.id = s.id AND u.id = '" +  possibleId + "'";
                //System.out.println(sqlQuery);
	 	// execute the SQL query statement          
		try
 		{
                    PreparedStatement RETRIEVE_STMT = aConnection.prepareStatement(sqlQuery);
                    ResultSet rs = RETRIEVE_STMT.executeQuery();
                    // next method sets cursor & returns true if there is data
                    
//                    boolean gotIt = rs.next();
                    
                    if (rs.next())
                    {	// extract the data
                        id = rs.getLong("id");
//                        password = rs.getString("password");
//			firstName = rs.getString("firstName");
//                        lastName = rs.getString("lastName");
//                        emailAddress = rs.getString("emailAddress");
//                        lastAccess = rs.getDate("lastAccess");
//                        enrolDate = rs.getDate("enrolDate");
//                        type = rs.getString("type").charAt(0);
//                        enabled = rs.getBoolean("enabled");
                        programCode = rs.getString("programCode");
                        programDescription = rs.getString("programDesc");
                        year = rs.getInt("year");
                        
                        			
			// create Customer
                        try{
                            aStudent = new Student(possibleId, password, firstName, 
                                    lastName, emailAddress, lastAccess, 
                                    enrolDate, type, enabled, programCode, 
                                    programDescription, year);
                            
                        }catch (Exception e)
                        { System.out.println("Record for id " + id + " contains an invalid data.  Verify and correct.");
                            System.out.println(e);}
                        
                    } else	// nothing was retrieved
                    {throw (new NotFoundException("Problem retrieving Student record, ID#" + possibleId + " does not exist in the system."));}
                    rs.close();
	   	}catch (SQLException e)
		{ System.out.println(e);}
                
		return aStudent;
	}  
    
    /**
     * This method will attempt to update and store an existing Student record, 
     * accepts a Student object as an argument, and throws NotFoundException, 
     * InvalidUserDataException errors.
     * 
     * @param aStudent takes a Student object args
     * @return records for this student
     * @throws NotFoundException if the student is not in the database
     */
    public static int update(Student aStudent) throws NotFoundException {
        
        int studentRecords = 0;
        
        id = aStudent.getId();
        programCode = aStudent.getProgramCode();
        programDescription = aStudent.getProgramDescription();
        year = aStudent.getYear();      
        
        String sqlUpdate2 = "UPDATE students SET programCode = ?, "
        + "programDesc = ?, "
        + "year = ? "        
        + "WHERE id = ?";
            
        System.out.println(sqlUpdate2);
        
        
        try {
            System.out.println("The updated password: " + password  );
            String hashedPassword = hashThePassword(password);
            
            aConnection.setAutoCommit(false);
            
            studentRecords = UserDA.update(aStudent);
            
            aStudent.retrieve(id);

            if (studentRecords > 0) {
                
                PreparedStatement UPDATE_STMT2 = aConnection.prepareStatement(sqlUpdate2);
                UPDATE_STMT2.setString(1, programCode);
                UPDATE_STMT2.setString(2, programDescription);
                UPDATE_STMT2.setInt(3, year);
                UPDATE_STMT2.setLong(4, id);                
                aConnection.commit();
                
            } else {
                aConnection.rollback();
            }
            
           
        } catch (NotFoundException e) {
            
            throw new NotFoundException("Student record with ID #" + id 
            + " cannot be updated, does not exist in the system.");
                       
        } catch (SQLException e) {
            
            System.out.println(e);
            
        }
        
        return studentRecords;
        
    }
    

    
    /**
     * This method will attempt to delete a Student record, accepts a Student object
     * as an argument, and throws NotFoundException, InvalidUserDataException errors.
     * 
     * @param aStudent takes a Student object args
     * @return a record
     * @throws NotFoundException if the student does not exist in the database
     */
    public static int delete(Student aStudent) throws NotFoundException {
        
        int records = 0;
        
        id = aStudent.getId();
        
        try {
           
            PreparedStatement DELETE_STMT = aConnection.prepareStatement("DELETE "
                + "FROM Students WHERE id = ?");
            
            Student.retrieve(id);
            
            records = DELETE_STMT.executeUpdate();
            DELETE_STMT.setLong(1, id);
            
        } catch (NotFoundException e) {
            
            throw new NotFoundException("Student with ID #" + id + " cannot be "
                    + "deleted, does not exist.");   
            
        } catch (SQLException e) {
            
            System.out.println(e);
            
        }
        
        return records;
        
    }   
}
