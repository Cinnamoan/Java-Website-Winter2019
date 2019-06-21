package webd4201.carlosi;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Vector;

/**
 * This class will be used to store a final grade in a course, it will also 
 * include the Student's GPA weighting, associated course code and description.
 * 
 * @author Ian Carlos
 * @since 1.0 (2019/1/18)
 * @version 1.0
 */
public class Mark {
    
    /**
     * Defines the minimum GPA value.
     */
    public final float MINIMUM_GPA = 0.0f;
    
    /**
     * Defines the maximum GPA value.
     */
    public final float MAXIMUM_GPA = 5.0f;
    
    /**
     * Defines the decimal format for GPA values.
     */
    public final DecimalFormat GPA = new DecimalFormat("0.0");
    
    /**
     * Stores the attribute that will contain the course code for the mark.
     */
    private String courseCode;
    
    /**
     * Stores the course name for the mark. 
     */
    private String courseName;
    
    /**
     * Stores the student's final result in the course.
     */
    private int result;
    
    /**
     * Holds the course's GPA weighting.
     */
    private float gpaWeighting;

    /**
     * Get method for the private method: courseCode
     * 
     * @return the courseCode string object
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Set method for the private attribute: courseCode
     * 
     * @param courseCode takes a string args
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Get method for the private method: courseName
     * 
     * @return courseName string object
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Set method for the private attribute: courseName
     * 
     * @param courseName takes a string args
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    /**
     * Get method for the private method: result
     * 
     * @return result int object
     */
    public int getResult() {
        return result;
    }

    /**
     * Set method for the private attribute: result
     * 
     * @param result takes an int args
     */
    public void setResult(int result) {
        this.result = result;
    }
    
    /**
     * Get method for the private method: gpaWeighting
     * 
     * @return gpaWeighting float object
     */
    public float getGpaWeighting() {
        return gpaWeighting;
    }

    /**
     * Set method for the private attribute: gpaWeighting
     * 
     * @param gpaWeighting takes a float args
     */
    public void setGpaWeighting(float gpaWeighting) {
        this.gpaWeighting = gpaWeighting;
    }
    
    
    /**
     * 
     * Attempt to open a connection to the database by calling the initialize
     * method of the MarkDA class.
     * 
     * @param c connection object
     */
    public static void initialize(Connection c) {
        MarkDA.initialize(c);
    }  
    
   /**
     * Create a Mark record based on this.
     * 
     * @throws DuplicateException if the student already exists in the database
     * @throws InvalidUserDataException  if data passed is invalid
     * @throws SQLException if general SQL errors were encountered
     */
    public void create() throws DuplicateException, InvalidUserDataException, SQLException {
	MarkDA.create(this);
    }
    
    /**
     * 
     * Retrieve a Mark record based on the ID given.
     * 
     * @param possibleId takes a long args
     * @return the student record
     * @throws NotFoundException if the student record was not found in the database
     * @throws SQLException if any general SQL encounters were encountered 
     */
    public static Mark retrieve(long possibleId) throws NotFoundException, SQLException {
	return MarkDA.retrieve(possibleId);
    }
    
    /**
     * Update a Mark record based on this.
     * 
     * @throws NotFoundException if student record was not found in the database
     */
    public void update() throws NotFoundException {
	MarkDA.update(this);
    }
    
    /**
     * Delete a Mark record based on this.
     * 
     * @throws NotFoundException if student record was not found in the databases
     */
    public void delete() throws NotFoundException {
	MarkDA.delete(this);
    }
    
    /**
     * 
     * Calls the retrieveAll method of the MarkDA class.
     * 
     * @param theId takes a long args
     * @return the marks of the student
     * @throws InvalidIdException if the student is invalid
     * @throws InvalidPasswordException if the password is invalid
     * @throws InvalidNameException if the name is invalid
     */
    public static Vector<Mark> retrieveAll(long theId) throws InvalidIdException, 
            InvalidPasswordException, InvalidNameException {
        return MarkDA.retrieveAll(theId);
    }    
    
    /**
     * 
     * Close the connection to the database by calling the terminate method
     * of the MarkDA class.
     * 
     */
    public static void terminate() {
        MarkDA.terminate();
    }     
    
    /**
     * Parameterized constructor that takes arguments: a course code,
     * course name, (final) result, and GPA weighting.
     * 
     * @param courseCode takes a string args
     * @param courseName takes a string args
     * @param result takes a int args
     * @param gpaWeighting takes a float args
     */
    public Mark(String courseCode, String courseName, int result, 
            float gpaWeighting) {
        
        setCourseCode(courseCode);
        setCourseName(courseName);
        setResult(result);
        setGpaWeighting(gpaWeighting);        
    }
    
    /**
     * 
     * Override string method that is specific to the Mark Class.
     * 
     * @return String
     */
    @Override
    public String toString() {
        String output = getCourseCode();
        output += "\t" + String.format( "%-35s", getCourseName());
        output += "\t" + getResult();
        output += "\t" + GPA.format(getGpaWeighting());
        
        return output;
    }
    
}
