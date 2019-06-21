package webd4201.carlosi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * 
 * This class will inherit attributes from the User class and will be used to 
 * store a student's program code, program description, current enrolled year
 * and a Vector of Mark objects.
 * 
 * @author Ian Carlos
 * @since 1.0 (2019/1/18)
 * @version 2.0
 */
public class Student extends User {
    
    /**
     * Stores the default value for a Student's program code.
     */
    public static final String DEFAULT_PROGRAM_CODE = "UNDC";
    
    /**
     * Stores the default value for a Student's program code description.
     */
    public static final String DEFAULT_PROGRAM_DESCRIPTION = "Undeclared";
    
    /**
     * Stores the default value for a Student's current year.
     */
    public static final int DEFAULT_YEAR = 1;
    
    /**
     * Stores the Student's program code.
     */
    private String programCode;
    
    /**
     * Stores the Student's program's description.
     */
    private String programDescription;
    
    /**
     * Stores the Student's current year.
     */
    private int year;
    
    /**
     * Vector of Mark objects named marks.
     */
    public Vector<Mark> marks; 
    
    /**
     * Attempt to open a connection to the database by calling the initialize
     * method of the StudentDA class.
     * 
     * @param c connection object
     */
    public static void initialize(Connection c) {
        StudentDA.initialize(c);
    }
        
    /**
     * 
     * Authenticate the entered student ID and password by calling the 
     * authenticate method of the StudentDA class.
     * 
     * @param possibleId takes a long args
     * @param aPassword takes a string args
     * @return if the student exists in the database or not
     * @throws NotFoundException if student does not exist in database 
     * @throws InvalidIdException if student ID is invalid
     * @throws InvalidUserDataException if data passed is invalid
     * @throws SQLException if any general SQL errors encountered
     */
    public static Student authenticate(long possibleId, String aPassword) throws 
            NotFoundException, InvalidIdException, InvalidUserDataException, SQLException {
        return StudentDA.authenticate(possibleId, aPassword);
    }
    
    
    /**
     * Terminate the connection to the database by calling the terminate method
     * of the StudentDA class.
     */
    public static void terminate() {
	StudentDA.terminate();
    }
    
    /**
     * Create a Student record based on this.
     * 
     * @throws DuplicateException if the student already exists in the database
     * @throws InvalidUserDataException  if data passed is invalid
     */
    public void create() throws DuplicateException, InvalidUserDataException, SQLException {
	StudentDA.create(this);
    }
    
    /**
     * 
     * Retrieve a Student record based on the ID given.
     * 
     * @param possibleId takes a long args
     * @return the student record
     * @throws NotFoundException if the student record was not found in the database
     * @throws SQLException if any general SQL encounters were encountered 
     */
    public static Student retrieve(long possibleId) throws NotFoundException, SQLException {
	return StudentDA.retrieve(possibleId);
    }
    
    /**
     * Update a Student record based on this.
     * 
     * @throws NotFoundException if student record was not found in the database
     */
    public void update() throws NotFoundException {
	StudentDA.update(this);
    }
    
    /**
     * Delete a Student record based on this.
     * 
     * @throws NotFoundException if student record was not found in the databases
     */
    public void delete() throws NotFoundException {
	StudentDA.delete(this);
    }

    /**
     * Get method for private attribute: programCode
     * 
     * @return programCode string object
     */
    public String getProgramCode() {
        return programCode;
    }
    
    /**
     * Set method for private attribute: programCode
     * 
     * @param programCode takes a string args
     */
    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }
    
    /**
     * Get method for private attribute: programDescription
     * 
     * @return programDescription string object
     */
    public String getProgramDescription() {
        return programDescription;
    }

    /**
     * Set method for private attribute: programDescription 
     * 
     * @param programDescription  takes a string args
     */
    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }
    
    /**
     * Get method for private attribute: year
     * 
     * @return year int object
     */
    public int getYear() {
        return year;
    }
    
    /**
     * Set method for private attribute: year
     * 
     * @param year takes an int args
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    /**
     * Get method for private attribute: marks
     * 
     * @return marks vector object
     */
    public Vector<Mark> getMarks() {
        return marks;
    }
    
    /**
     * Set method for private attribute: marks
     * 
     * @param marks takes a vector of Mark args
     */
    public void setMarks(Vector<Mark> marks) {
        this.marks = marks;
    }
       
    /**
     * A parameterized constructor that takes one argument each for the inherited 
     * and new Student attributes. 
     * 
     * @param uId takes a long args
     * @param uPassword takes a string args
     * @param uFirstName takes a string args
     * @param uLastName takes a string args
     * @param uEmailAddress takes a string args
     * @param uLastAccess takes a date args
     * @param uEnrolDate takes a date args
     * @param uType takes a char args
     * @param uEnabled takes a boolean args
     * @param programCode takes a string args
     * @param programDescription takes a string args
     * @param year takes an int args
     * @param marks takes a vector of Mark args
     * @throws InvalidUserDataException if the data passed is invalid
     */
    public Student(long uId, String uPassword, String uFirstName, 
            String uLastName, String uEmailAddress, Date uLastAccess, 
            Date uEnrolDate, char uType, boolean uEnabled, String programCode, 
            String programDescription, int year, Vector<Mark> marks) throws 
            InvalidUserDataException {
        super(uId, uPassword, uFirstName, uLastName, uEmailAddress, uLastAccess, 
                uEnrolDate, uType, uEnabled);
        
        setProgramCode(programCode);
        setProgramDescription(programDescription);
        setYear(year);
        setMarks(marks);       
    }
    
    /**
     * An overloaded constructor that takes arguments for all attributes for
     * a Student object except for a Vector of Mark objects. This will call
     * the above constructor, send all of its arguments, and pass an empty
     * vector of Mark objects.
     * 
     * @param uId takes a long args
     * @param uPassword takes a string args
     * @param uFirstName takes a string args
     * @param uLastName takes a string args
     * @param uEmailAddress takes a string args
     * @param uLastAccess takes a date args
     * @param uEnrolDate takes a date args
     * @param uType takes a char args
     * @param uEnabled takes a boolean args
     * @param programCode takes a string args
     * @param programDescription takes a string args
     * @param year takes an int args
     * @throws InvalidUserDataException if the passed data is invalid
     * @throws InvalidIdException if the student ID is invalid
     */
    public Student(long uId, String uPassword, String uFirstName, 
            String uLastName, String uEmailAddress, 
            Date uLastAccess, Date uEnrolDate, char uType, boolean uEnabled,
            String programCode, String programDescription, int year) throws 
            InvalidIdException, InvalidUserDataException  {
        this(uId, uPassword, uFirstName, uLastName, uEmailAddress, new Date(), 
                new Date(), uType, uEnabled, programCode, programDescription, 
                year, new Vector<Mark>());
    }
    
    /**
     * A default constructor that calls the overloaded parameterized constructor 
     * which passes all the default values.
     * 
     * @throws InvalidIdException if the student ID is invalid
     * @throws InvalidUserDataException if the passed data is invalid
     */
    public Student() throws InvalidIdException, InvalidUserDataException {
        this(DEFAULT_ID, DEFAULT_PASSWORD, DEFAULT_FIRST_NAME, 
                DEFAULT_LAST_NAME, DEFAULT_EMAIL_ADDRESS, new Date(), 
                new Date(), DEFAULT_TYPE, DEFAULT_ENABLED_STATUS,
                DEFAULT_PROGRAM_CODE, DEFAULT_PROGRAM_DESCRIPTION, 
                DEFAULT_YEAR);
    }
    
    /**
     * 
     * Override string method that is specific for the Faculty Class.
     * 
     * @return String
     */
    @Override
    public String toString() {
        
        String output;
        
        output = getTypeForDisplay() + " info for:";
        output += "\n\t" + getFirstName() + getLastName() + " (" + getId() 
                + ")"; 
        output += "\n\tCurrently in " + getYear(); 
        
        if (getYear() == 1) {
            output += "st";
        } else if (getYear() == 2) {
            output += "nd";
        } else if (getYear() == 3) {
            output += "rd";
        } else {
            output += "th";
        }
        
        output += " year of \"" + getProgramDescription() + "\" (" 
                + getProgramCode() + ")"; 
        output += "\n\tEnrolled: " + DF.format(getEnrolDate());
        
        output = output.replaceAll("User", "Student");
            
        return output;       
    }

    /**
     * 
     * Implements the abstract getTypeForDisplay() method so that it simply returns
     * the word "Student".
     * 
     * @return String
     */
    @Override
    public String getTypeForDisplay() {
       return "Student";
    }
    
    
}
