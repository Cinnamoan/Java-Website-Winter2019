 package webd4201.carlosi;

/**
 * Interface that stores some shared college information as class constants.
 * 
 * @author Ian Carlos
 * @version 1.0 (2019/1/9)
 * @since 1.0
 */
public interface CollegeInterface {
    
    /**
     * Stores the name of the educational institute.
     */
    public static String COLLEGE_NAME = "Durham College";
    
    /**
     * Stores the number of the educational institute.
     */
    public static String PHONE_NUMBER = "(905)721-2000";
    
    /**
     * Stores the minimum ID number.
     */
    public static long MINIMUM_ID_NUMBER = 100000000l;
    
    /**
     * Stores the maximum ID number.
     */
    public static long MAXIMUM_ID_NUMBER = 999999999l;
    
    /**
     * Returns a string that converts the single character type to a human
     * readable form.
     * @return string 
     */
    public String getTypeForDisplay();   
    
}
