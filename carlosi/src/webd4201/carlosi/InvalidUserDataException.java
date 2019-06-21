package webd4201.carlosi;

/**
 *
 * This customized exception will be used to indicate if any passed data 
 * to create a User object is incorrect.
 * 
 * @author Ian Carlos
 * @version 1.0 (2019/1/25)
 * @since 1.0
 */
@SuppressWarnings("serial")
public class InvalidUserDataException extends Exception {
    
    /**
     * Overload the default constructor of the Exception class that takes
     * no arguments.
     */
    public InvalidUserDataException() {
        
    }
    
    /**
     * Overload the default constructor of the Exception class that takes 
     * a string argument, which will be used to display the error message.
     * 
     * @param errorMessage takes a string args
     */
    public InvalidUserDataException(String errorMessage) {
        super(errorMessage);
    }
    
}
