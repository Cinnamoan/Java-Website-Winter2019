package webd4201.carlosi;

import java.sql.*;
import java.util.Vector;

/**
 *
 * Contains all the CRUD methods for the Mark class and its attributes
 *
 * @author Ian Carlos
 * @since 1.0 (2019/04/08)
 * @version 1.0
 */
public class MarkDA {

    /**
     * Static connection object used for database connection.
     */
    static Connection aConnection;

    /**
     * Static statement object used for database connection.
     */
    static Statement aStatement;

    /**
     * Static Mark object used to set and get attributes of a (Student's) Mark.
     */
    static Mark aMark;
    
    /**
     * Static variable to that will be used to reference a student ID to their
     * respective course marks.
     */
    static long id;

    /**
     * Static variable to contain (students) mark references.
     */
    static Vector<Mark> marks = new Vector<Mark>();

    /**
     * Static variable for Mark courseCode instance attribute.
     */
    static String courseCode;

    /**
     * Static variable for Mark courseName instance attribute.
     */
    static String courseName;

    /**
     * Static variable for Mark result instance attribute.
     */
    static int result;

    /**
     * Static variable for Mark gpaWeightin instance attribute.
     */
    static float gpaWeighting;

    /**
     * This method will be used to establish a database connection, takes a
     * Connection object as an argument, and throws an SQLException error.
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

        } catch (SQLException e) {

            System.out.println(e);

        }
    }

    /**
     *
     * This method will be attempt to create a Mark object and store it in
     * the database, takes in a Student object argument, and throws two
     * exceptions: DuplicateException, InvalidUserDataException
     *
     * @param aMark takes a Mark object args
     * @return isInserted - insertion success flag
     * @throws DuplicateException if a student record already exists
     * @throws InvalidUserDataException if passed data is invalid
     * @throws SQLException if any general SQL errors encountered
     */
    public static boolean create(Mark aMark) throws DuplicateException, InvalidUserDataException,
            SQLException {

        boolean isInserted = false;

        courseCode = aMark.getCourseCode();
        courseName = aMark.getCourseName();
        result = aMark.getResult();
        gpaWeighting = aMark.getGpaWeighting();

        try {

            retrieve(id);

            throw (new DuplicateException("Problem with creating a Student "
                    + "record, ID " + id + " already exists in the system."));

        } catch (NotFoundException e) {

            try {

                String sqlCreate1 = "INSERT INTO courses(coursecode, coursetitle, gpaweighting) value (?, ?, ?)";

                // Prepared Statements help prevent SQL injection!!
                String sqlCreate2 = "INSERT INTO marks("
                        + "coursecode, id, result) values (?, ?, ?)";

                System.out.println(sqlCreate2);
                System.out.println(sqlCreate2);

                PreparedStatement CREATE_STMT1 = aConnection.prepareStatement(sqlCreate1);
                CREATE_STMT1.setString(1, courseCode);
                CREATE_STMT1.setString(2, courseName);
                CREATE_STMT1.setFloat(3, gpaWeighting);

                PreparedStatement CREATE_STMT2 = aConnection.prepareStatement(sqlCreate2);
                CREATE_STMT2.setString(1, courseCode);
//                CREATE_STMT2.setString(2, );
                CREATE_STMT2.setFloat(3, result);

                isInserted = CREATE_STMT1.execute();
                isInserted = CREATE_STMT2.execute();

            } catch (SQLException er) {

                System.out.println(er);
//                System.out.println(id);               
            }
        }
        return isInserted;
    }

    /**
     * This method will attempt to retrieve a Mark record by accepting a long
     * argument, and throws NotFoundException and InvalidUserDataException
     * errors.
     *
     * @param possibleId takes a long args
     * @return aMark object
     * @throws NotFoundException if the student ID is not found in the database
     */
    public static Mark retrieve(long possibleId) throws NotFoundException { // retrieve Customer and Boat data
        aMark = null;
        // define the SQL query statement using the phone number key
        String sqlQuery = "SELECT c.coursecode, c.coursetitle, c.gpaweighting, "
                + "m.coursecode, m.id, m.result FROM courses c, marks m WHERE  "
                + "c.coursecode = m.coursecode AND m.id = '" + possibleId + "'";
        //System.out.println(sqlQuery);
        // execute the SQL query statement          
        try {
            PreparedStatement RETRIEVE_STMT = aConnection.prepareStatement(sqlQuery);
            ResultSet rs = RETRIEVE_STMT.executeQuery();
            // next method sets cursor & returns true if there is data

//                    boolean gotIt = rs.next();
            if (rs.next()) {	// extract the data
                courseCode = rs.getString("coursecode");
                courseName = rs.getString("coursetitle");
                gpaWeighting = rs.getFloat("gpaweighting");
                result = rs.getInt("result");

                // create Customer
                try {
                    aMark = new Mark(courseCode, courseName, (int) gpaWeighting, result);

                } catch (Exception e) {
                    System.out.println("Record for id " + possibleId + " contains an invalid data.  Verify and correct.");
                    System.out.println(e);
                }

            } else // nothing was retrieved
            {
                throw (new NotFoundException("Problem retrieving Student record, ID#" + possibleId + " does not exist in the system."));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return aMark;
    }

    /**
     * This method will attempt to update and store an existing Student record,
     * accepts a Mark object as an argument, and throws NotFoundException,
     * InvalidUserDataException errors.
     *
     * @param aMark takes a Mark object args
     * @return records for this student
     * @throws NotFoundException if the student is not in the database
     */
    public static int update(Mark aMark) throws NotFoundException {

        int records = 0;

//        id = aStudent.getId();
        courseCode = aMark.getCourseCode();
        courseName = aMark.getCourseName();
        result = aMark.getResult();
        gpaWeighting = aMark.getGpaWeighting();

        try {
            String sqlUpdate1 = "UPDATE courses SET coursecode = ?, coursetitle = ?, gpaweighting = ?";

            // Prepared Statements help prevent SQL injection!!
            String sqlUpdate2 = "UPDATE marks SET coursecode = ?, id = ?, result = ?";

            PreparedStatement UPDATE_STMT1 = aConnection.prepareStatement(sqlUpdate1);
            UPDATE_STMT1.setString(1, courseCode);
            UPDATE_STMT1.setString(2, courseName);
            UPDATE_STMT1.setFloat(3, gpaWeighting);

            PreparedStatement UPDATE_STMT2 = aConnection.prepareStatement(sqlUpdate2);
            UPDATE_STMT2.setString(1, courseCode);
//                UPDATE_STMT2.setString(2, );
            UPDATE_STMT2.setFloat(3, result);

            aMark.retrieve(id);

//            records = UPDATE_STMT1.executeUpdate();
            records = UPDATE_STMT1.executeUpdate();
            records = UPDATE_STMT2.executeUpdate();

        } catch (NotFoundException e) {

            throw new NotFoundException("Student record with ID #" + id
                    + " cannot be updated, does not exist in the system.");

        } catch (SQLException e) {

            System.out.println(e);

        }

        return records;

    }
    
    /**
     * This method will attempt to delete a Mark record, accepts a Student object
     * as an argument, and throws NotFoundException, InvalidUserDataException errors.
     * 
     * @param aMark takes a Mark object args
     * @return a record
     * @throws NotFoundException if the student does not exist in the database
     */
    public static int delete(Mark aMark) throws NotFoundException {
        
        int records = 0;
        
//        id = aStudent.getId();
        
        try {
     
            PreparedStatement DELETE_STMT1 = aConnection.prepareStatement("DELETE "
                + "FROM courses WHERE id = ?");
            
            PreparedStatement DELETE_STMT2 = aConnection.prepareStatement("DELETE "
                + "FROM marks WHERE id = ?");
            
            Mark.retrieve(id);
            
            records = DELETE_STMT1.executeUpdate();
            records = DELETE_STMT2.executeUpdate();
            DELETE_STMT1.setString(1, courseCode);
//            DELETE_STMT2.setString(2, );s
            
            
        } catch (NotFoundException e) {
            
            throw new NotFoundException("Student with ID #" + id + " cannot be "
                    + "deleted, does not exist.");   
            
        } catch (SQLException e) {
            
            System.out.println(e);
            
        }
        
        return records;
        
    }   

    /**
     *
     * Attempt to get a student's grade for all of their past and/or currently
     * for courses based on their student ID.
     *
     * @param theId the student Id
     * @return the marks of the student
     * @throws InvalidIdException if the id is invalid
     * @throws InvalidPasswordException if the password is invalid
     * @throws InvalidNameException if the name is invalid
     */
    public static Vector<Mark> retrieveAll(long theId) throws InvalidIdException,
            InvalidPasswordException, InvalidNameException {

        String sqlQuery = "SELECT ?, ?, ? FROM Marks";

        try {

            PreparedStatement RETRIEVE_ALL_STMT = aConnection.prepareStatement(sqlQuery);
            RETRIEVE_ALL_STMT.setString(1, courseCode);
            RETRIEVE_ALL_STMT.setLong(2, theId);
            RETRIEVE_ALL_STMT.setInt(3, result);
            ResultSet rs = RETRIEVE_ALL_STMT.executeQuery();

            boolean moreData = rs.next();

            while (moreData) {
                System.out.println("Course Code: " + rs.getString(1));
                System.out.println("Id: " + rs.getString(2));
                System.out.println("Result: " + rs.getString(3));
            }

            try {
                aMark = new Mark(courseCode, courseName, result, gpaWeighting);
            } catch (Exception e) {
                System.out.println("Something went wrong trying to create a new "
                        + "Mark object for Student #" + theId);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return marks;

    }

}
