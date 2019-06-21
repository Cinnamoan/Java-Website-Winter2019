package webd4201.carlosi;

/**
 *
 * This customized exception will be used in setId method(s) and subsequently
 * all constructors that use the latter.
 * 
 * @author Ian Carlos
 * @version 1.0 (2019/1/25)
 * @since 1.0
 */
@SuppressWarnings("serial")
public class InvalidIdException extends Exception {
    
    /**
     * Overload the default constructor of the Exception class that takes
     * no arguments.
     */
    public InvalidIdException() {
        
    } 
    
    /**
     * Overload the default constructor of the Exception class that takes 
     * a string argument, which will be used to display the error message.
     * 
     * @param errorMessage takes a string args
     */
    public InvalidIdException(String errorMessage) {
        super(errorMessage);
    }
    
}
