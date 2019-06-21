package webd4201.carlosi;

/**
 *
 * This customized exception will be thrown when if a duplicate record
 * is found in the database.
 * 
 * @author Ian Carlos
 * @version 1.0 (2019/1/27)
 * @since 1.0 
 */
@SuppressWarnings("serial")
public class DuplicateException extends Exception {
    
    /**
     * Overload the default constructor of the Exception class that takes
     * no arguments.
     */
    public DuplicateException() {
        
    }
    
    /**
     * Overload the default constructor of the Exception class that takes 
     * a string argument, which will be used to display the error message.
     * 
     * @param errorMessage takes a string args
     */
    public DuplicateException(String errorMessage) {
        super(errorMessage);
    }
    
}
