package webd4201.carlosi;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.*;
import java.util.Date;
import java.util.Locale;
import javax.mail.internet.*;
import java.security.*;

/**
 * A User, will be extended into specialized class including Student
 * and Faculty, while also access methods from the UserDA class.
 * 
 * @author Ian Carlos
 * @version 1.0 (2019/1/11)
 * @since 1.0
 */
public class User implements CollegeInterface {
    
    /**
     * Default ID for a User, used in case if not provided.
     */
    public static final long DEFAULT_ID = 100123456l;
    
    /**
     * Default password for a User, used in case if not provided.
     */
    public static final String DEFAULT_PASSWORD = "password";
    
    /**
     * Default first name for a User, used in case if not provided.
     */
    public static final String DEFAULT_FIRST_NAME = "John";
    
    /**
     * Default last name for a User, used in case if not provided.
     */
    public static final String DEFAULT_LAST_NAME = "Doe";
    
    /**
     * Default email address for a User, used in case if not provided.
     */
    public static final String DEFAULT_EMAIL_ADDRESS = "john.doe@dcmail.com";
    
    /**
     * Default enabled status for a User.
     */
    public static final boolean DEFAULT_ENABLED_STATUS = true;
    
    /**
     * Default type for a User.
     */
    public static final char DEFAULT_TYPE = 's';
    
    /**
     * Default ID number length for a User.
     */
    public static final byte ID_NUMBER_LENGTH  = 9;
    
    /**
     * Defines the minimum length of a User's password.
     */
    public static final byte MINIMUM_PASSWORD_LENGTH = 8;
    
    /**
     * Defines the maximum length of a User's password.
     */
    public static final byte MAXIMUM_PASSWORD_LENGTH = 20;
    
    /**
     * Formats date into Canadian date style.
     */
    public static final DateFormat DF = 
            DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);
    
    /**
     * Variable that stores a User's unique identification number.
     */
    private long id;
    
    /**
     * Variable that stores a User's password.
     */
    private String password;
    
    /**
     * Variable that stores a User's first name.
     */
    private String firstName;
    
    /**
     * Variable that stores a User's last name.
     */
    private String lastName;
    
    /**
     * Variable that stores a User's email address.
     */
    private String emailAddress;
    
    /**
     * Variable that stores the date when the User last accessed their account.
     */
    private Date lastAccess;
    
    /**
     * Variable that stores when the User was enrolled.
     */
    private Date enrolDate;
    
    /**
     * Stores the status of a User.
     */
    private boolean enabled;
    
    /**
     * Stores the type of a User.
     */
    private char type;

    /**
     * Get method for the private attribute: id
     * 
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Set and validate the private attribute: id
     * 
     * @param id takes a long args
     * @throws InvalidIdException if id given is not found in database
     */
    public void setId(long id) throws InvalidIdException {
//        System.out.println("Id passed is: " + id);
        // Check if the ID is within range
        if(id >= MINIMUM_ID_NUMBER && id <= MAXIMUM_ID_NUMBER) {
            
            // Set this value to the attribtue
            this.id = id;
        } else { // If not
            
            // Then throw error and display error message.
            throw new InvalidIdException("Employee ID must be between " + 
                    MINIMUM_ID_NUMBER + " and " + MAXIMUM_ID_NUMBER);
        }        
    }

    /**
     * Get method for the private attribute: password
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /** 
     * Set and validate the private attribute: password
     * 
     * @param password the password to set
     */
    public void setPassword(String password) {
        
//        if(password.length() >= MINIMUM_PASSWORD_LENGTH && password.length() <= 
//                MAXIMUM_PASSWORD_LENGTH) {
             this.password = password;
//        } else {
//            throw new InvalidPasswordException("Password must be between " + 
//                    MINIMUM_PASSWORD_LENGTH + " and " + 
//                    MAXIMUM_PASSWORD_LENGTH);
//        }
       
    }

    /**
     * Get method for the private attribute: firstName
     * 
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set and validate the private attribute: firstName
     * 
     * @param firstName the firstName to set
     * @throws InvalidNameException hello
     */
    public void setFirstName(String firstName) throws InvalidNameException {
                  
        if(firstName.isEmpty()) { // Check if the string is empty
            
            // Throw error and display error message.
            throw new InvalidNameException("First name cannot be empty.");
            
        } else {
            
            try {
                
                // Check if the string contains an integer.
               Double.parseDouble(firstName);
                
            } catch (NumberFormatException nfe) {
                
                 this.firstName = firstName;
            } 
        }
    }

    /**
     * Get method for the private attribute: lastName
     * 
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set and validate the private attribute: lastName
     * 
     * @param lastName the lastName to set
     * @throws InvalidNameException if Name does not pass validation
     */
    public void setLastName(String lastName) throws InvalidNameException {
        
        if(lastName.isEmpty()) { // Check if the string is empty
            
            // Throw error and display error message.
            throw new InvalidNameException("Last name cannot be empty.");
            
        } else {
            
            try {
                
                // Check if the string contains an integer.
                Double.parseDouble(lastName);
               // Throw error and display error message.
               throw new InvalidNameException("Last name cannot be an number, you entered: " + lastName+".");
                
            } catch (NumberFormatException nfe) {
                this.lastName = lastName;
            } 
        }
    }

    /**
     * Get method for the private attribute: emailAddress
     * 
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Set method for the private attribute: emailAddress
     * 
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Get method for the private attribute: lastAccess
     * 
     * @return the lastAccess
     */
    public Date getLastAccess() {
        return lastAccess;
    }

    /**
     * Set method for the private attribute: lastAccess
     * 
     * @param lastAccess the lastAccess to set
     */
    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    /**
     * Get method for the private attribute: enrolDate 
     * 
     * @return the enrolDate
     */
    public Date getEnrolDate() {
        return enrolDate;
    }

    /**
     * Set method for the private attribute: enrolDate
     * 
     * @param enrolDate the enrolDate to set
     */
    public void setEnrolDate(Date enrolDate) {
        this.enrolDate = enrolDate;
    }

    /**
     * Get method for the private attribute: enabled
     * 
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Set method for the private attribute: enabled
     * 
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Get method for the private attribute: type
     * 
     * @return the type
     */
    public char getType() {
        return type;
    }

    /**
     * Set method for the private attribute: type
     * 
     * @param type the type to set
     */
    public void setType(char type) {
        this.type = type;
    }
    
    /**
     * 
     * Parameterized constructor that accepts arguments, each for the types
     * corresponding to the attributes listed, and places each argument into
     * its appropriate attribute by using the mutators created above.
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
     * @throws InvalidUserDataException if the passed data is invalid
     */
    public User(long uId, String uPassword, String uFirstName, String uLastName, 
            String uEmailAddress, Date uLastAccess, Date uEnrolDate, 
            char uType, boolean uEnabled) throws InvalidUserDataException {
        try{
            setId(uId);
            setPassword(uPassword);
            setFirstName(uFirstName);
            setLastName(uLastName);
            setEmailAddress(uEmailAddress);
            setLastAccess(uLastAccess);
            setEnrolDate(uEnrolDate);
            setEnabled(uEnabled);
            setType(uType);
            
        }catch(Exception e)
        {
            throw new InvalidUserDataException(e.getMessage());
        }
              
    }
    
    /**
     * Attempt to open a connection to the database by calling the initialize
     * method of the UserDA class.
     * 
     * @param c the connection object
     */
    public static void initialize(Connection c) {
        UserDA.initialize(c);
    }
    
    /**
     * Terminate the connection to the database by calling the terminate method
     * of the UserDA class.
     */
    public static void terminate() {
	StudentDA.terminate();
    }
    
    /**
     * Create a User record based on this.
     * 
     * @throws DuplicateException if a record already exists
     * @throws InvalidUserDataException if the record is invalid
     * @throws NoSuchAlgorithmException ...
     * @throws SQLException if an sql error has been encountered
     */
    public void create() throws DuplicateException, InvalidUserDataException, 
            NoSuchAlgorithmException, SQLException {
	UserDA.create(this);
    } 
    
    /**
     * 
     * Retrieve a User record based on this.
     * 
     * @param possibleId takes a long args
     * @return user record based on their used ID
     * @throws NotFoundException if a record was not found
     * @throws SQLException if an sql error was encountered
     */
    public static User retrieve(long possibleId) throws NotFoundException, SQLException {
	return UserDA.retrieve(possibleId);
    }
    
    /**
     * Update a User record based on this.
     * 
     * @throws NotFoundException if the record was not found in the database
     */
    public void update() throws NotFoundException {
	UserDA.update(this);
    }
    
    /**
     * Delete a User record based on this.
     * 
     * @throws NotFoundException if the record was not found in the database
     */
    public void delete() throws NotFoundException {
	UserDA.delete(this);
    }    
    
    /**
     * Default constructor that will set the instance attributes to the
     * public class attributes by calling the parameterized constructor.
     * 
     * @throws InvalidUserDataException if the passed data is invalid
     */
    public User() throws InvalidUserDataException {
        this(DEFAULT_ID, DEFAULT_PASSWORD, DEFAULT_FIRST_NAME, 
                DEFAULT_LAST_NAME, DEFAULT_EMAIL_ADDRESS, new Date(), 
                new Date(), DEFAULT_TYPE, DEFAULT_ENABLED_STATUS);
    }
    
    /**
     * Overload the string object to create a specific User's information as a
     * string in the form.
     * 
     * @return output
     */
    @Override
    public String toString() {
        String output = "User Info for: " + getId();
        output += "\n\tName: " + getFirstName() + " " + getLastName();
        output += "\n\tCreated on: " + DF.format(getEnrolDate());
        output += "\n\tLast access: " + DF.format(getLastAccess());
        
        return output;
    }
    
    /**
     * This instance method will not take any arguments, return nothing and
     * will just only display the toString() method using:
     * System.out.println(toString()).
     */
    public void dump()
    {
        System.out.println(toString());
    }
    
    /**
     * This static method will accept a long argument and checks, using the 
     * minimum and maximum values for a valid ID, then returns a boolean value.
     * 
     * @param id takes a long args
     * @return isTrue if the user ID exists in the database
     */
    public static boolean verifyId(long id) {
        
        boolean isTrue = true;
        
        if(id >= MINIMUM_ID_NUMBER && id <= MAXIMUM_ID_NUMBER) {
            return isTrue;
        } else {
            isTrue = false;
            
            return isTrue;
        }    
    }

    /**
     *
     * Function used to verify if the email address input by the user is valid.
     * 
     * @param email takes a string args
     * @return if the email is valid or not
     */
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
    
    /**
     * Returns a string that converts the single character type to a human
     * readable form.
     * @return string 
     */
    @Override
    public String getTypeForDisplay() {
            return "User";
    }
}
