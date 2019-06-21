package webd4201.carlosi;

/**
 *
 * This customized exception will be thrown if a record could not be found
 * in the database.
 * 
 * @author Ian Carlos
 * @version 1.0 (2019/1/27)
 * @since 1.0
 */
@SuppressWarnings("serial")
public class NotFoundException extends Exception {
    
    /**
     * Overload the default constructor of the Exception class that takes
     * no arguments.
     */    
    public NotFoundException() {
        
    }
    
    /**
     * Overload the default constructor of the Exception class that takes 
     * a string argument, which will be used to display the error message.
     * 
     * @param errorMessage takes a string args
     */
    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }
    
}
