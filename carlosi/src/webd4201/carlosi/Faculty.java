package webd4201.carlosi;

/**
 *
 * This class will inherit attributes from the User class and will  be used to 
 * store a faculty's school code, school description, office 
 * and phone extension.
 * 
 * @author Ian Carlos
 * @version 1.0 (2019/1/14)
 * @since 1.0
 */
public class Faculty extends User {
    
    /**
     * Define the default value for a faculty's school code.
     */
    public final String DEFAULT_SCHOOL_CODE = "SET";
    
     /**
     * Define the default value for a faculty's school description.
     */
    public final String DEFAULT_SCHOOL_DESCRIPTION = "School of Engineering "
            + "and Technology";
    
    /**
     * Define the default value for a faculty's office.
     */    
    public final String DEFAULT_OFFICE = "H-140";
    
    /**
     * Define the default value for a faculty's phone extension.
     */
    public final int DEFAULT_PHONE_EXTENSION = 1234;
    
    /**
     * Stores the code for the school the faculty is associated with.
     */
    private String schoolCode;
    
    /**
     * Stores the code description of the school the faculty is associated with.
     */
    private String schoolDescription;
    
    /**
     * Stores the faculty member's office.
     */
    private String office;
    
    /**
     * Stores the faculty member's phone extension.
     */
    private int extension;

    /**
     * Get method for the private attribute: schoolCode 
     *
     * @return schoolCode
     */
    public String getSchoolCode() {
        return schoolCode;
    }

    /**
     * Set method for the private attribute: schoolCode
     * 
     * @param schoolCode takes a string args
     */
    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    /**
     * Get method for the private attribute: schoolDescription 
     *
     * @return schoolDescription
     */
    public String getSchoolDescription() {
        return schoolDescription;
    }

    /**
     * Set method for the private attribute: schoolCode
     * 
     * @param schoolDescription  takes a string args
     */
    public void setSchoolDescription(String schoolDescription) {
        this.schoolDescription = schoolDescription;
    }

    /**
     * Get method for the private attribute: office 
     *
     * @return office
     */
    public String getOffice() {
        return office;
    }

    /**
     * Set method for the private attribute: office
     * 
     * @param office takes a string args
     */
    public void setOffice(String office) {
        this.office = office;
    }

    /**
     * Get method for the private attribute: extension 
     *
     * @return extension
     */
    public int getExtension() {
        return extension;
    }

    /**
     *  Set method for the private attribute: extension
     * 
     * @param extension takes an int args
     */
    public void setExtension(int extension) {
        this.extension = extension;
    }
    
    /**
     * 
     * A parameterized constructor that takes one argument each for the inherited
     * and new attributes, then calls the User class parameterized constructor;
     * passing all User arguments provided. Throws InvalidUserDataException
     * if there is an error in any of the arguments provided.
     * 
     * @param schoolCode takes a string args
     * @param schoolDescription takes a string args
     * @param office takes a string args
     * @param extension takes a int args
     * @throws InvalidUserDataException if any passed data is invalid
     */
    public Faculty(String schoolCode, String schoolDescription, String office, 
            int extension) throws InvalidUserDataException {
        super();
        
        setSchoolCode(schoolCode);
        setSchoolDescription(schoolDescription);
        setOffice(office);
        setExtension(extension);                     
    }
    
    /**
     * 
     * A default constructor which calls the User class default constructor while
     * setting all the default values for the new attributes. 
     * 
     * @throws InvalidUserDataException if any passed data is invalid
     */
    public Faculty() throws InvalidUserDataException {
        super();
        
        setSchoolCode(DEFAULT_SCHOOL_CODE);
        setSchoolDescription(DEFAULT_SCHOOL_DESCRIPTION);
        setOffice(DEFAULT_OFFICE);
        setExtension(DEFAULT_PHONE_EXTENSION);
    }

    /**
     * 
     * Implements the abstract getTypeForDisplay() method so that it simply returns
     * the word "Faculty".
     * 
     * @return String
     */
    @Override
    public String getTypeForDisplay() {
        return "Faculty";
    } 
    
    /**
     * Override string method that is specific to the Faculty Class.
     * 
     * @return String 
     */
    @Override
    public String toString() {
        
        super.toString();
        
        String output;
        
        output = getTypeForDisplay() + " info for: " + getId();
        output += "\n\tName: " + getFirstName() + " " + getLastName() + " (" + 
                getEmailAddress() + ")";
        output += "\n\tCreated on: " + DF.format(getEnrolDate());
        output += "\n\tLast Access: " + DF.format(getLastAccess());
        output += getSchoolDescription() + " (" + getSchoolCode() + ")";
        output += "\n\tOffice: " + getOffice();
        output += "\n\t" + PHONE_NUMBER + " x" + getExtension();
        
        output = output.replaceAll("User", "Faculty");
        
        return output;
    }
}
